package br.com.sharewave.sharewave.repositories;

import br.com.sharewave.sharewave.entities.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
