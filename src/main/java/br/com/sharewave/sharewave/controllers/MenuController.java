package br.com.sharewave.sharewave.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/menu")
public class MenuController {

    @GetMapping
    public String showMenu() {
        return "menu/menu";
    }

}
