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

        User user = new User();
        user.setName(name.trim());
        return userRepository.save(user);
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User does not exist: " + userId));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
