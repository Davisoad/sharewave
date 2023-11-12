package br.com.sharewave.sharewave.controllers;

import br.com.sharewave.sharewave.repositories.UserRepository;
import br.com.sharewave.sharewave.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/consult")
public class ConsultController {

    private final UserRepository userRepository;

    public ConsultController(UserService userService, UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String showUsers(@RequestParam(name = "name", required = false) String name, Model model) {
        if (name != null && !name.isEmpty()) {
            model.addAttribute("users", userRepository.findUsersByName(name));
        }
        return "consult/consult-list";
    }
}

