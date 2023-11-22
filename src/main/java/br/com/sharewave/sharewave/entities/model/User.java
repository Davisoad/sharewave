package br.com.sharewave.sharewave.entities.model;

import br.com.sharewave.sharewave.dtos.UserDTO;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String address;
    private String phone;
    private String email;
    private String date;

    public User (UserDTO data) {
        this.name = data.name();
        this.password = data.password();
        this.address = data.address();
        this.phone = data.phone();
        this.email = data.email();
        this.date = data.date();
    }

    public <E> User(String username, String password, ArrayList<E> es) {
        this.name = username;
        this.password = password;
    }
}
