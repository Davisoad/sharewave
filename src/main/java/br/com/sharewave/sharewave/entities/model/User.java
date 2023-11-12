package br.com.sharewave.sharewave.entities.model;

import br.com.sharewave.sharewave.dtos.UserDTO;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String address;
    private String phone;
    private String email;
    private LocalDate date;
//    @ManyToMany
//    @JoinTable(name = "followers_users")
//    private List<Follower> followers;

    public User() {
    }

    public User(String name, String password, String address, String phone, String email, LocalDate date) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.date = date;
    }

    public User (UserDTO data) {
        this.name = data.name();
        this.password = data.password();
        this.address = data.address();
        this.phone = data.phone();
        this.email = data.email();
        this.date = data.date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
