package br.com.sharewave.sharewave.controllers;

import br.com.sharewave.sharewave.dtos.CommentDTO;
import br.com.sharewave.sharewave.entities.model.Comment;
import br.com.sharewave.sharewave.services.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping(path = "/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public String showComments(Model model) {
        model.addAttribute("comment", commentService.getAllComment());
        return "comments/comment-list";
    }

    @GetMapping(path = "/add")
    public String showAddCommentForm(Model model) {
        model.addAttribute("comment", new Comment());
        return "comments/add-comment";
    }

    @PostMapping(path = "/add")
    public String addComment(@ModelAttribute("comment") CommentDTO data) {
        commentService.createComment(data);
        return "redirect:/comment";
    }

    @GetMapping(path = "/edit/{id}")
    public String showEditCommentForm(@PathVariable(name = "id") Long id, Model model) {
        Optional<Comment> comment = commentService.findCommentById(id);
        if (comment.isPresent()) {
            model.addAttribute("comment", comment.get());
            return "comments/edit-comment";
        }
        else {
            return "redirect:/comment";
        }
    }

    @PostMapping(path = "/edit/{id}")
    public String editComment(@PathVariable(name = "id") Long id, @ModelAttribute(name = "comment") CommentDTO data) {
        commentService.updateComment(id, data);
        return "redirect:/comment";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
        return "redirect:/comment";
    }
}
