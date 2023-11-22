package br.com.sharewave.sharewave.repositories;

import br.com.sharewave.sharewave.entities.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUsername(String username);
}
