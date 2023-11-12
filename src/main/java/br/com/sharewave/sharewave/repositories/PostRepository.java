package br.com.sharewave.sharewave.repositories;

import br.com.sharewave.sharewave.entities.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
