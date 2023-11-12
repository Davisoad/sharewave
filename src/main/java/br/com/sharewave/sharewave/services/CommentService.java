package br.com.sharewave.sharewave.services;

import br.com.sharewave.sharewave.dtos.CommentDTO;
import br.com.sharewave.sharewave.entities.model.Comment;
import br.com.sharewave.sharewave.repositories.CommentRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Iterable<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    public Optional<Comment> findCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void createComment(CommentDTO data) {
        saveComment(new Comment(data));
    }

    public void updateComment(Long id, CommentDTO data) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found! "));

       comment.setCommentContent(data.commentContent());
       comment.setCommentDate(data.commentDate());
       comment.setIdPost(data.idPost());
       comment.setIdUser(data.idUser());

        saveComment(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
