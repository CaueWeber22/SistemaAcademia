package com.adm.academia.controller;

import com.adm.academia.data.ExercicioEntity;
import com.adm.academia.data.UsuarioEntity;
import com.adm.academia.service.ExercicioService;
import com.adm.academia.service.GrupoMuscularService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//CONTROLLER PARA FUNCIONÁRIOS
@Controller
public class ExercicioController {

    //Inicialização de services
    @Autowired
    ExercicioService exercicioService;

    @Autowired
    GrupoMuscularService gmService;

    //Endpoint para abrir tela inicial de exercícios
    @GetMapping("/Exercicios")
    public ModelAndView viewExercicios() {
        ModelAndView mv = new ModelAndView("/TelasExercicios/Exercicios");
        //Add todos exercícios e grupos musculares ao mv
        mv.addObject("exercicios", exercicioService.getAllExercicios());//Retornar todos exercícios
        mv.addObject("grupos_musculares", gmService.getAllGruposMusculares());//Retornar todos grupos musculares

        return mv;
    }

    //Endpoint para pesquisa de exercícios na tabela
    @PostMapping("/Exercicios")
    public ModelAndView pesquisarExercicios(@RequestParam(value = "nome_exercicio", required = false) String nome,
            @RequestParam(value = "id_grupo_muscular", required = false) Integer idGrupoMuscular) {
        ModelAndView mv = new ModelAndView("/TelasExercicios/Exercicios");
        mv.addObject("grupos_musculares", gmService.getAllGruposMusculares()); //Retornar todos grupos musculares

        //Condicionais para pesquisa de exercício
        if (nome != null && idGrupoMuscular == null) { //Caso apenas o nome tenha sido pesquisado
            mv.addObject("exercicios", exercicioService.getExercicioByNome(nome));
        } else if (nome == null && idGrupoMuscular != null) { //Caso apenas o grupo muscular tenha sido pesquisado
            mv.addObject("exercicios", exercicioService.getExercicioByIdGrupoMuscular(idGrupoMuscular));
        } else if (nome != null && idGrupoMuscular != null) { //Caso grupo muscular e nome tenham sido pesquisados
            mv.addObject("exercicios", exercicioService.getExercicioByIdGmAndNome(idGrupoMuscular, nome));
        } else { //Retornar todos exercícios cada nada tenha sido pesquisado
            mv.addObject("exercicios", exercicioService.getAllExercicios());
        }

        return mv;
    }

    //Endpoint para abrir tela de cadastro de exercícios
    @GetMapping("/CadastrarExercicios")
    public ModelAndView viewCadastrarExercicios() {
        ModelAndView mv = new ModelAndView("/TelasExercicios/CadastrarExercicios");
        //Add todos exercícios e grupos musculares ao mv
        mv.addObject("exercicio", new ExercicioEntity());
        mv.addObject("grupos_musculares", gmService.getAllGruposMusculares());//Retornar todos grupos musculares

        return mv;
    }

    //Endpoint para abrir tela de cadastro de exercícios
    @PostMapping("/CadastrarExercicios")
    public String CadastrarExercicios(
            @Valid @ModelAttribute("exercicio") ExercicioEntity exercicio, BindingResult result) {
        exercicio.setId(null); //Setar do exercício id como null

        if (result.hasErrors()) {
            return "/CadastrarExercicios";
        }
        exercicioService.criarExercicio(exercicio); //Call para o service salvar dados no DB

        return "redirect:/CadastrarExercicios";
    }
    
    //Endpoint para abrir tela de exclusão de exercícios
    @GetMapping("/ExcluirExercicio")
    public ModelAndView viewExcluirExercicio() {
        ModelAndView mv = new ModelAndView("/TelasExercicios/ExcluirExercicio");
    
        mv.addObject("showModal", "false");// Define que o modal não deve ser exibido
        mv.addObject("exercicio", new ExercicioEntity());
        
        return mv;
    }
    
   // Endpoint para buscar exercício que será excluído e confirmar a exclusão
    @PostMapping("/ExcluirExercicio")
    public ModelAndView ExcluirExercicio(Model model, @RequestParam(value = "id_exercicio") Integer id) {
        ModelAndView mv = new ModelAndView("/TelasExercicios/ExcluirExercicio");
        ExercicioEntity exercicio = exercicioService.getExercicioById(id);
        mv.addObject("showModal", "true");// Define que o modal deve ser exibido

        if (exercicio != null) { 
           mv.addObject("exercicio", exercicio);

        } else {
            mv.addObject("exercicio", new ExercicioEntity());
            mv.addObject("mensagem", "Exercicio não encontrado para o ID " + id);
        }
        return mv;
    }
    
    // Endpoint para realizar exclusão de exercício
    @PostMapping("/ConfirmExclusaoExercicio")
    public String ConfirmExclusaoExercicio(@RequestParam(value = "id") Integer id, Model model) {
       exercicioService.deletarExercicio(id);
       
        return "redirect:/Exercicios";
    }
    
}
