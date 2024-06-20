package com.adm.academia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author cauew
 */
//Controller para telas inicias do site
@Controller
public class SiteController {

    //Abrir tela inicial
    @GetMapping("/TelaInicial")
    public String viewTelaInicial() {
        return "inicioGerenciamento";
    }
}
