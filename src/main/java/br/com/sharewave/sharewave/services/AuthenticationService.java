package br.com.sharewave.sharewave.services;

import br.com.sharewave.sharewave.entities.model.Login;
import br.com.sharewave.sharewave.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean authenticate(String username, String password) {
        Login user = loginRepository.findByUsername(username);

        return user != null && user.getPassword().equals(password);
    }
}
