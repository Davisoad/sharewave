package br.com.sharewave.sharewave.services;

import br.com.sharewave.sharewave.dtos.UserDTO;
import br.com.sharewave.sharewave.entities.model.User;
import br.com.sharewave.sharewave.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void createUser(UserDTO data) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate localDate = LocalDate.parse(data.date(), inputFormatter);
        String formattedDate = localDate.format(outputFormatter);

        UserDTO newUserDTO = new UserDTO(
                data.name(),
                data.password(),
                data.address(),
                data.phone(),
                data.email(),
                formattedDate
        );

        saveUser(new User(newUserDTO));
    }


    public void updateUser(Long id, UserDTO data) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate localDate = LocalDate.parse(data.date(), inputFormatter);
        String formattedDate = localDate.format(outputFormatter);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setName(data.name());
        user.setEmail(data.email());
        user.setAddress(data.address());
        user.setPassword(data.password());
        user.setDate(formattedDate);
        user.setPhone(data.phone());

        saveUser(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
