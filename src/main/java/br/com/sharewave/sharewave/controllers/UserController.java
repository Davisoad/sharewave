package br.com.sharewave.sharewave.controllers;

import br.com.sharewave.sharewave.dtos.UserDTO;
import br.com.sharewave.sharewave.entities.model.User;
import br.com.sharewave.sharewave.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;
    //private final List<User> UserList = new ArrayList<>();

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping
//    public String getUser(){
//        return "users/UserRegister";
//    }
//    @PostMapping
//    public String postUser(UserDTO data)
//    {
//        UserList.add(new User(data));
//        System.out.println(UserList);
//
//        return "users/UserRegister";
//    }

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("user", userService.getAllUser());
        return "users/user-list";
    }

    @GetMapping(path = "/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "users/add-user";
    }

    @PostMapping(path = "/add")
    public String addUser(@ModelAttribute("user") UserDTO data) {
        userService.createUser(data);
        return "redirect:/user";
    }

    @GetMapping(path = "/edit/{id}")
    public String showEditUserForm(@PathVariable(name = "id") Long id, Model model) {
        Optional<User> user = userService.findUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "users/edit-user";
        }
        else {
            return "redirect:/user";
        }
    }

    @PostMapping(path = "edit/{id}")
    public String editUser(@PathVariable(name = "id") Long id, @ModelAttribute(name = "user") UserDTO data) {
        userService.updateUser(id, data);
        return "redirect:/user";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }

}
