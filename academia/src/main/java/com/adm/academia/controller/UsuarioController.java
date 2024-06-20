package com.adm.academia.controller;

import com.adm.academia.data.UsuarioEntity;
import com.adm.academia.service.TreinoService;
import com.adm.academia.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//CONTROLLER PARA USUÁRIO
@Controller
public class UsuarioController {

    //Inicialização de services
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    TreinoService treinoService;

    //Endpoint para abrir inicial de usuários
    @GetMapping("/Usuarios")
    public ModelAndView viewUsuarios(Model model) {
        ModelAndView mv = new ModelAndView("/TelasUsuario/Usuarios");
        mv.addObject("usuarios", usuarioService.getAllUsuarios());

        return mv;
    }

    //Endpoint para pesquisa de usuários na tabela
    @PostMapping("/Usuarios")
    public ModelAndView pesquisarUsuarioId(Model model, @RequestParam(value = "id_usuario", required = false) Integer id) {
        ModelAndView mv = new ModelAndView("/TelasUsuario/Usuarios"); //Atribuir URL ao mv

        if (id == null) {
            mv.addObject("usuarios", usuarioService.getAllUsuarios());
        } else {
            mv.addObject("usuarios", usuarioService.getUsuarioById(id));
        }

        return mv; //Retornar URL e usuarios encontrados para o object usuarios
    }

    //Endpoint para abrir tela de cadastro de usuários
    @GetMapping("/CadastrarUsuario")
    public String viewCadastrarUsuario(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        model.addAttribute("treinos", treinoService.getAllTreinos());

        return "TelasUsuario/CadastrarUsuario";
    }

    //Endpoint para cadastro de usuário
    @PostMapping("/CadastroUsuario")
    public String CadastroUsuario(@Valid @ModelAttribute("usuario") UsuarioEntity usuario, BindingResult result) {
        if (result.hasErrors()) { //Condicional para mostrar erro e cancelar save no DB
            return "CadastroUsuario";
        }
        usuarioService.criarUsuario(usuario);

        return "redirect:/CadastrarUsuario"; //Recarregar a página
    }

    // Endpoint para abrir tela de alteração de plano/treino de usuário
    @GetMapping("/AlterarUsuario")
    public String viewAlterarUsuario(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        model.addAttribute("treinos", treinoService.getAllTreinos());
        return "TelasUsuario/AlterarUsuario";
    }

    // Endpoint para pesquisar usuário por ID e redirecionar para a página de alteração
    @PostMapping("/AlterarUsuario")
    public String pesquisarUsuarioAlteracao(@RequestParam("id_usuario") Integer id) {
        return "redirect:/Alterar/" + id;
    }

    // Endpoint para exibir dados do usuário por ID para alteração
    @GetMapping("Alterar/{id}")
    public String exibirAlterarDadosUsuario(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("treinos", treinoService.getAllTreinos());

        // Buscar usuário pelo ID
        UsuarioEntity usuario = usuarioService.getUsuarioById(id);

        if (usuario != null) { //Verificar se usuário existe ou retornou null
            model.addAttribute("usuario", usuario);
        } else {
            model.addAttribute("usuario", new UsuarioEntity());
            model.addAttribute("mensagem", "Usuário não encontrado para o ID " + id);
        }

        return "TelasUsuario/Alterar";
    }

    // Endpoint para alterar dados de usuário
    @PostMapping("/Alterar")
    public String AlterarDados(
            @Valid @ModelAttribute("usuario") UsuarioEntity usuario, BindingResult result) {
        if (result.hasErrors()) { //Checar se houve erro       
            return "TelasUsuario/Alterar";
        }
        usuarioService.alterarUsuario(usuario, usuario.getId_carteirinha());

        return "redirect:/AlterarUsuario";
    }

    // Endpoint para abrir tela de exclusão de usuário
    @GetMapping("/ExclusaoUsuario")
    public String viewExclusaoUsuario(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        model.addAttribute("showModal", "false");// Define que o modal não deve ser exibido
        
        return "TelasUsuario/ExclusaoUsuario";
        
    }

    // Endpoint para buscar usuário que será excluído e confirmar a exclusão
    @PostMapping("/ExclusaoUsuario")
    public ModelAndView ExcluirUsuario(Model model, @RequestParam(value = "id_usuario") Integer id) {
        ModelAndView mv = new ModelAndView("TelasUsuario/ExclusaoUsuario");
        UsuarioEntity usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("showModal", "true");// Define que o modal deve ser exibido

        if (usuario != null) { 
            model.addAttribute("usuario", usuario);

        } else {
            model.addAttribute("usuario", new UsuarioEntity());
            model.addAttribute("mensagem", "Usuário não encontrado para o ID " + id);

        }
        return mv;
    }
    
    // Endpoint para realizar exclusão de usuário
    @PostMapping("/Excluir")
    public String ConfirmExcluirUsuario(@RequestParam(value = "id") Integer id, Model model) {
        usuarioService.deletarUsuario(id);
       
        return "redirect:/Usuarios";
    }
    
    

}
