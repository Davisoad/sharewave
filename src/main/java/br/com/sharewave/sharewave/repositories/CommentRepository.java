package br.com.sharewave.sharewave.repositories;

import br.com.sharewave.sharewave.entities.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
