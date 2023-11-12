package br.com.sharewave.sharewave.services;

import br.com.sharewave.sharewave.dtos.UserDTO;
import br.com.sharewave.sharewave.entities.model.User;
import br.com.sharewave.sharewave.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
        saveUser(new User(data));
    }

    public void updateUser(Long id, UserDTO data) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setName(data.name());
        user.setEmail(data.email());
        user.setAddress(data.address());
        user.setPassword(data.password());
        user.setDate(data.date());
        user.setPhone(data.phone());

        saveUser(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
