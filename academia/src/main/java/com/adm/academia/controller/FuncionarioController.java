package com.adm.academia.controller;

import com.adm.academia.data.FuncionarioEntity;
import com.adm.academia.service.CargoService;
import com.adm.academia.service.FuncionarioService;
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
public class FuncionarioController {

    //Inicialização de services
    @Autowired
    FuncionarioService funcionarioService;
    
    @Autowired
    CargoService cargoService;

    //Endpoint para abrir tela inicial de funcionários
    @GetMapping("/Funcionarios")
    public ModelAndView viewFuncionarios() {
        ModelAndView mv = new ModelAndView("/TelasFuncionarios/Funcionarios");
        //Add todos funcionários e cargos ao mv
        mv.addObject("funcionarios", funcionarioService.getAllFuncionarios());
        mv.addObject("cargos", cargoService.getAllCargos());
        
        return mv;
    }

    //Endpoint para pesquisa por ID de funcionários na tabela
    @PostMapping("/Funcionarios/ID")
    public ModelAndView pesquisarFuncionarioId(@RequestParam(value = "id_funcionario", required = false) Integer id) {
        
        ModelAndView mv = new ModelAndView("/TelasFuncionarios/Funcionarios"); //Atribuir URL ao mv

        if (id == null) { //Retornar todos funcionários se pesqusia de ID estiver vazia
            mv.addObject("funcionarios", funcionarioService.getAllFuncionarios());
        } else {
            mv.addObject("funcionarios", funcionarioService.getFuncionarioById(id));
        }
        return mv;
    }

    //Endpoint para pesquisa por nome de funcionários na tabela
    @PostMapping("/Funcionarios/Nome")
    public ModelAndView pesquisarFuncionarioNome(@RequestParam(value = "nome_funcionario", required = false) String nome) {
        
        ModelAndView mv = new ModelAndView("/TelasFuncionarios/Funcionarios"); //Atribuir URL ao mv

        if (nome == null) { //Retornar todos funcionários se pesqusia de nome estiver vazia
            mv.addObject("funcionarios", funcionarioService.getAllFuncionarios());
        } else {
            mv.addObject("funcionarios", funcionarioService.getFuncionarioByNome(nome));
        }
        return mv;
    }

    //Endpoint para abrir tela inicial de cadastro funcionários
    @GetMapping("/CadastrarFuncionario")
    public String viewCadastrarFuncionario(Model model) {

        //Add todos funcionários e cargos ao model
        model.addAttribute("funcionario", new FuncionarioEntity());
        model.addAttribute("cargos", cargoService.getAllCargos());
        
        return "/TelasFuncionarios/CadastrarFuncionario";
    }

    //Endpoint para realizar cadastro dos dados de um funcionário  
    @PostMapping("/CadastrarFuncionario")
    public String CadastrarFuncionario(
            @Valid @ModelAttribute("funcionario") FuncionarioEntity funcionario, BindingResult result) {
        funcionario.setAtivo(true);
        
        if (result.hasErrors()) { //Condicional para mostrar erro e cancelar save no DB         
            return "CadastrarFuncionario";
            
        }
        funcionarioService.criarFuncionario(funcionario);
        
        return "redirect:/CadastrarFuncionario";
    }

    //Endpoint para abrir tela de exclusão de funcionário
    @GetMapping("/ExclusaoFuncionario")
    public String viewExclusaoFuncionario(Model model) {
        
        model.addAttribute("funcionario", new FuncionarioEntity());
        model.addAttribute("showModal", "false");// Define que o modal não deve ser exibido

        return "/TelasFuncionarios/ExclusaoFuncionario";
    }

    // Endpoint para buscar funcionário que será excluído e confirmar a exclusão
    @PostMapping("/ExclusaoFuncionario")
    public ModelAndView ExclusaoFuncionario(Model model, @RequestParam(value = "id_funcionario") Integer id) {
        ModelAndView mv = new ModelAndView("TelasFuncionarios/ExclusaoFuncionario");
        
        FuncionarioEntity funcionario = funcionarioService.getFuncionarioById(id);
        model.addAttribute("showModal", "true");// Define que o modal deve ser exibido

        if (funcionario != null) { //Verificar se funcionário foi encontrado e retornar para o front
            model.addAttribute("funcionario", funcionario);
            
        } else {
            model.addAttribute("funcionario", new FuncionarioEntity());
            model.addAttribute("mensagem", "Funcionario não encontrado para o ID " + id);
            
        }
        return mv;
    }

    // Endpoint para realizar exclusão de funcionário
    @PostMapping("/ConfirmExcluirFunc")
    public String ConfirmExcluirFuncionario(@RequestParam(value = "id") Integer id, Model model) {
        funcionarioService.deletarFuncionario(id);
        
        return "redirect:/Funcionarios";
    }

    //Endpoint para abrir tela de alteração de status de um funcionário
    @GetMapping("/AlterarFuncionario")
    public String viewAlterarFuncionario(Model model) {
        
        model.addAttribute("funcionario", new FuncionarioEntity());
        model.addAttribute("tipoAlteracao", "null");// Define que as opções de alteração não devem exibidas

        return "/TelasFuncionarios/AlterarFuncionario";
    }

    //Endpoint para abrir tela de alteração de status de um funcionário
    @PostMapping("/AlterarFuncionario")
    public String AlterarFuncionario(Model model, @RequestParam(value = "id_funcionario") Integer id,
            @RequestParam(value = "opcoes") String tipoAlteracao) {
        // Buscar funcionário pelo ID
        FuncionarioEntity funcionario = funcionarioService.getFuncionarioById(id);
        
        if (funcionario != null) { //Verificar se funcionário existe ou retornou null
            model.addAttribute("funcionario", funcionario);
            model.addAttribute("tipoAlteracao", tipoAlteracao);// Define qual opção alteração deve ser exibida
        } else {
            model.addAttribute("funcionario", new FuncionarioEntity());
            model.addAttribute("tipoAlteracao", "naoEncontrado");
        }
        return "/TelasFuncionarios/AlterarFuncionario";
    }

    //Endpoint para desativar funcionário
    @PostMapping("/DesativarFuncionario")
    public String DesativarFuncionario(
            @RequestParam(value = "data_demissao") LocalDate data_demissao, 
            @RequestParam(value = "id_funcionario") Integer id) {
        
        //Buscar usuário que será desativado
        FuncionarioEntity alteracaoFuncionario = funcionarioService.getFuncionarioById(id);
        
        alteracaoFuncionario.setAtivo(false); //Setar funcionário como não ativo
        alteracaoFuncionario.setData_demissao(data_demissao); //Setar data de demissão

        //Call para o service
        funcionarioService.alterarFuncionario(alteracaoFuncionario, id);
        
        return "redirect:/Funcionarios";
    }
    
     //Endpoint para ativar funcionário
    @PostMapping("/AtivarFuncionario")
    public String AtivarFuncionario(        
            @RequestParam(value = "id_funcionario") Integer id) {
        
        //Buscar usuário que será ativado
        FuncionarioEntity alteracaoFuncionario = funcionarioService.getFuncionarioById(id);
        
        alteracaoFuncionario.setAtivo(true); //Setar funcionário como não ativo
        alteracaoFuncionario.setData_demissao(null); //Setar data de demissão como null

        //Call para o service
        funcionarioService.alterarFuncionario(alteracaoFuncionario, id);
        
        return "redirect:/Funcionarios";
    }
    
}
