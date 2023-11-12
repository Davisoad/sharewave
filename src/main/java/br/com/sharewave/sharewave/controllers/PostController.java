package br.com.sharewave.sharewave.controllers;

import br.com.sharewave.sharewave.dtos.PostDTO;
import br.com.sharewave.sharewave.entities.model.Post;
import br.com.sharewave.sharewave.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping(path = "/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String showPosts(Model model) {
        model.addAttribute("post", postService.getAllPost());
        return "posts/post-list";
    }

    @GetMapping(path = "/add")
    public String showAddPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/add-post";
    }

    @PostMapping(path = "/add")
    public String addPost(@ModelAttribute("post") PostDTO data) {
        postService.createPost(data);
        return "redirect:/post";
    }

    @GetMapping(path = "/edit/{id}")
    public String showEditPostForm(@PathVariable(name = "id") Long id, Model model) {
        Optional<Post> post = postService.findPostById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
            return "posts/edit-post";
        }
        else {
            return "redirect:/post";
        }
    }

    @PostMapping(path = "/edit/{id}")
    public String editPost(@PathVariable(name = "id") Long id, @ModelAttribute(name = "post") PostDTO data) {
        postService.updatePost(id, data);
        return "redirect:/post";
    }

    @GetMapping(path = "/delete/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);
        return "redirect:/post";
    }
}
