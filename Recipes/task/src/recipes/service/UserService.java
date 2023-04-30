package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import recipes.model.User;
import recipes.repository.UserRepository;
import recipes.security.UserAlreadyExistsException;

import javax.management.openmbean.KeyAlreadyExistsException;

@Service
public class UserService {

    private final UserRepository users;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    public void add(User user) {
        if (users.existsById(user.getEmail())) {
            throw new UserAlreadyExistsException();
        }
        if (user.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        //String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users.save(user);
    }

    public void delete(User user) {
        users.delete(user);
    }
}
