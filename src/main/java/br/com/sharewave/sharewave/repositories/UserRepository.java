package br.com.sharewave.sharewave.repositories;

import br.com.sharewave.sharewave.entities.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        // Consultas Derived Query
        List<User> findByName(String name);
        List<User> findByNameAndPhone(String name, String phone);
        // consulta usando nativeQuery
        @Query(value = "SELECT * FROM User u WHERE u.name = :name", nativeQuery = true)
        List<User> findUsersByName(@Param("name") String name);
        // Consulta JPQL para encontrar usuários pelo nome
        @Query("SELECT u FROM User u WHERE u.email = :email")
        List<User> findUsersByEmail(@Param("email") String email);

        // Consulta JPQL para encontrar usuários com idade superior a um valor específico
        @Query("SELECT u FROM User u WHERE FUNCTION('DATED-IFF', YEAR, u.date, CURRENT_DATE) > :age")
        List<User> findUsersByAgeGreaterThan(@Param("age") int age);
}
