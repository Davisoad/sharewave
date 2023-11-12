package br.com.sharewave.sharewave.controllers;

import br.com.sharewave.sharewave.dtos.LikeDTO;
import br.com.sharewave.sharewave.entities.model.Like;
import br.com.sharewave.sharewave.services.LikeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping(path = "/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public String showLikes(Model model) {
        model.addAttribute("like", likeService.getAllLike());
        return "likes/like-list";
    }

    @GetMapping(path = "/add")
    public String showAddLikeForm(Model model) {
        model.addAttribute("like", new Like());
        return "likes/add-like";
    }

    @PostMapping(path = "/add")
    public String addLike(@ModelAttribute("like") LikeDTO data) {
        likeService.createLike(data);
        return "redirect:/like";
    }

    @GetMapping(path = "/edit/{id}")
    public String showEditLikeForm(@PathVariable(name = "id") Long id, Model model) {
        Optional<Like> like = likeService.findLikeById(id);
        if (like.isPresent()) {
            model.addAttribute("like", like.get());
            return "likes/edit-like";
        }
        else {
            return "redirect:/like";
        }
    }

    @PostMapping(path = "/edit/{id}")
    public String editLike(@PathVariable(name = "id") Long id, @ModelAttribute(name = "like") LikeDTO data) {
        likeService.updateLike(id, data);
        return "redirect:/like";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteLike(@PathVariable("id") Long id) {
        likeService.deleteLike(id);
        return "redirect:/like";
    }
}
