package service;

import model.User;
import repository.UserRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }

        User user = new User(userRepository.getNextId(), name.trim());
        userRepository.save(user);
        return user;
    }

    public User getUserById(int userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User does not exist: " + userId);
        }
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
