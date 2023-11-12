package br.com.sharewave.sharewave.repositories;

import br.com.sharewave.sharewave.entities.model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowerRepository extends JpaRepository<Follower, Long> {
}
