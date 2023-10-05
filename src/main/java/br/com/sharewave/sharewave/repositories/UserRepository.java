package br.com.sharewave.sharewave.repositories;

import br.com.sharewave.sharewave.entities.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
