package br.com.sharewave.sharewave.controllers;

import br.com.sharewave.sharewave.dtos.FollowerDTO;
import br.com.sharewave.sharewave.entities.model.Follower;
import br.com.sharewave.sharewave.services.FollowerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping(path = "/follower")
public class FollowerController {

    private final FollowerService followerService;

    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @GetMapping
    public String showFollowers(Model model) {
        model.addAttribute("follower", followerService.getAllFollower());
        return "followers/follower-list";
    }

    @GetMapping(path = "/add")
    public String showAddFollowerForm(Model model) {
        model.addAttribute("follower", new Follower());
        return "followers/add-follower";
    }

    @PostMapping(path = "/add")
    public String addFollower(@ModelAttribute("follower") FollowerDTO data) {
        followerService.createFollower(data);
        return "redirect:/follower";
    }

    @GetMapping(path = "/edit/{id}")
    public String showEditFollowerForm(@PathVariable(name = "id") Long id, Model model) {
        Optional<Follower> follower = followerService.findFollowerById(id);
        if (follower.isPresent()) {
            model.addAttribute("follower", follower.get());
            return "followers/edit-follower";
        }
        else {
            return "redirect:/follower";
        }
    }

    @PostMapping(path = "/edit/{id}")
    public String editFollower(@PathVariable(name = "id") Long id, @ModelAttribute(name = "follower") FollowerDTO data) {
        followerService.updateFollower(id, data);
        return "redirect:/follower";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteFollower(@PathVariable("id") Long id) {
        followerService.deleteFollower(id);
        return "redirect:/follower";
    }
}
