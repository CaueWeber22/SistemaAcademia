package com.adm.academia.controller;

import com.adm.academia.data.ExercicioTreinoId;
import com.adm.academia.data.ExerciciosTreinoEntity;
import com.adm.academia.data.TreinoEntity;
import com.adm.academia.service.ExercicioService;
import com.adm.academia.service.TreinoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//CONTROLLER PARA TREINOS
@Controller
public class TreinoController {

    //Inicialização de services
    @Autowired
    TreinoService treinoService;

    @Autowired
    ExercicioService exercicioService;

    //Endpoint para abrir tela inicial de treinos
    @GetMapping("/Treinos")
    public ModelAndView viewTreinos() {
        ModelAndView mv = new ModelAndView("/TelasTreinos/Treinos");
        //Add todos treinos ao mv
        mv.addObject("treinos", treinoService.getAllTreinos());

        return mv;
    }

    //Endpoint para abrir tela de cadastro de treinos
    @GetMapping("/CadastroTreino")
    public ModelAndView viewCadastroTreino() {
        ModelAndView mv = new ModelAndView("/TelasTreinos/CadastroTreino");
        //Add objeto treino ao mv
        mv.addObject("treino", new TreinoEntity());

        return mv;
    }

    //Endpoint para post de cadastro de treinos
    @PostMapping("/CadastroTreino")
    public String CadastroTreino(
            @Valid @ModelAttribute("treino") TreinoEntity treino, BindingResult result) {

        treino.setId(null);
        if (result.hasErrors()) { //Verificar se houve erro na requisição
            return "/CadastroTreino";
        }
        treinoService.criarTreino(treino); //Realizar cadastro do treino

        return "redirect:/CadastroTreino";
    }

    //Endpoint para abrir tela de alteração de treinos
    @GetMapping("/AlterarTreino")
    public String viewAlterarTreino(Model model) {

        //Add objeto treino ao mv
        model.addAttribute("treino", new TreinoEntity());
        model.addAttribute("showDivAlterar", "false"); //Indicar que divs de alteração não devem aparecer

        return "/TelasTreinos/AlterarTreino";
    }

    //Endpoint para pesquisar treino que será alterado
    @PostMapping("/AlterarTreino")
    public String AlterarTreino(Integer id_treino, Model model) {

        model.addAttribute("showDivAlterar", "true"); //Indicar que divs de alteração devem aparecer

        // Buscar treino pelo ID
        TreinoEntity treino = treinoService.getTreinoById(id_treino);

        if (treino != null) { //Verificar se treino existe ou retornou null
            model.addAttribute("treino", treino);
        } else {
            model.addAttribute("treino", new TreinoEntity());
            model.addAttribute("mensagem", "Treino não encontrado com o ID " + id_treino);
        }

        return "/TelasTreinos/AlterarTreino";
    }

    //Endpoint para requisição de alteração de dados de um treino
    @PostMapping("/ConfirmAlterarTreino")
    public String ConfirmAlterarTreino(@Valid @ModelAttribute("treino") TreinoEntity treino, BindingResult result) {
        if (result.hasErrors()) { //Verificar se houve erro na requisição
            return "/AlterarTreino";
        }
        treinoService.alterarTreino(treino, treino.getId()); //Realizar alteração

        return "redirect:/Treinos";
    }

    //Endpoint para abrir tela de exclusão de treino
    @GetMapping("/ExcluirTreino")
    public ModelAndView viewExcluirTreino() {
        ModelAndView mv = new ModelAndView("/TelasTreinos/ExcluirTreino");
        //Adicionar todos treinos ao mv
        mv.addObject("treino", new TreinoEntity());
        mv.addObject("showModal", false); //Indicar que modal NÃO deve ser exibido

        return mv;
    }

    //Endpoint para pesquisar treino que será excluído
    @PostMapping("/ExcluirTreino")
    public ModelAndView ExcluirTreino(Integer id_treino) {
        ModelAndView mv = new ModelAndView("/TelasTreinos/ExcluirTreino");
        mv.addObject("showModal", true); //Indicar que modal deve ser exibido
        //Pesqusiar usuário que será pesquisado
        TreinoEntity treino = treinoService.getTreinoById(id_treino);

        //Verificar se o treino foi encontrado ou não
        if (treino != null) {
            mv.addObject("treino", treino); //Add treino ao mv
        } else {
            mv.addObject("treino", new TreinoEntity()); //Add treino vazio caso não seja encontrado
        }

        return mv;
    }

    //Endpoint para confirmar exclusão do treino
    @PostMapping("/ConfirmExcluirTreino")
    public String confirmExcluirTreino(Integer id_treino_exclusao) {
        treinoService.deletarTreino(id_treino_exclusao);

        return "redirect:/Treinos";
    }

    //Endpoint para abrir tela de seleção de treino que será visualizado
    @GetMapping("/ExerciciosTreino")
    public ModelAndView viewExerciciosTreino() {
        ModelAndView mv = new ModelAndView("/TelasTreinos/ExerciciosTreino");
        //Adicionar todos treinos ao mv
        mv.addObject("treinos", treinoService.getAllTreinos());

        return mv;
    }
    
    //Endpoint para abrir tela de visualização de treino e detalhes
    @GetMapping("/ExerciciosTreino/Treino")
    public ModelAndView viewVisualizarTreino(@RequestParam("id_treino") Integer id_treino) {
        ModelAndView mv = new ModelAndView("/TelasTreinos/VisualizarTreino");
        //Adicionar treino ao mv
        TreinoEntity treino = treinoService.getTreinoById(id_treino);
        mv.addObject("treino", treino);
        //Adicionar exercícios que estão no treino
        mv.addObject("exercicios", treinoService.getExerciciosByTreinoId(id_treino)); 
        
        return mv;
    }
    
    //Endpoint para abrir tela para adicionar exercício a um treino
    @GetMapping("/ExerciciosTreino/Treino/Adicionar")
    public ModelAndView viewAdicionarExercicio(@RequestParam("id_treino") Integer id_treino) {
        ModelAndView mv = new ModelAndView("/TelasTreinos/AdicionarExercicio");
        //Adicionar treino ao mv
        TreinoEntity treino = treinoService.getTreinoById(id_treino);
        mv.addObject("treino", treino);
        //Adicionar todos os exercícios ao mv
        mv.addObject("exercicios", exercicioService.getAllExercicios()); 
        //Adicionar treino ao objeto exercicios treino
        ExerciciosTreinoEntity et = new ExerciciosTreinoEntity();
        et.setTreino(treino);
        mv.addObject("exerciciosTreino", et); 
        
        return mv;
    }
    
    //Endpoint para requisição de adição de exercício ao treino
    @PostMapping("/ExerciciosTreino/Treino/Adicionar")
    public String adicionarExercicio( 
            @ModelAttribute("exerciciosTreino") ExerciciosTreinoEntity et ) {
        treinoService.adicionarExercicioTreino(et);
 
        return ("redirect:/ExerciciosTreino/Treino?id_treino="+et.getTreino().getId());
    }
    
    //Endpoint para abrir tela para remover exercício de um treino
    @GetMapping("/ExerciciosTreino/Treino/Remover")
    public ModelAndView viewRemoverExercicio(@RequestParam("id_treino") Integer id_treino) {
        ModelAndView mv = new ModelAndView("/TelasTreinos/RemoverExercicio");
        //Adicionar treino ao mv
        TreinoEntity treino = treinoService.getTreinoById(id_treino);
        mv.addObject("treino", treino);
        //Adicionar ao mv todos exercícios ligados ao treino
        mv.addObject("exercicios", treinoService.getExerciciosByTreinoId(id_treino));
        
        return mv;
    }
    
    //Endpoint para requisição de remoção de exercício de um treino
    @PostMapping("/ExerciciosTreino/Treino/Remover")
    public String removerExercicio( 
            @RequestParam("id_treino") Integer idTreino, @RequestParam("id_exercicio") Integer idExercicio) {
        
        treinoService.removerExercicioTreino(idExercicio, idTreino);//Call para service
        
        return ("redirect:/ExerciciosTreino/Treino?id_treino="+idTreino);
    }


}
