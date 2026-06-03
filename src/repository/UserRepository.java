package repository;

import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private final Map<Integer, User> users;
    private int nextId;

    public UserRepository() {
        this.users = new HashMap<>();
        this.nextId = 1;
    }

    public int getNextId() {
        return nextId++;
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User findById(int id) {
        return users.get(id);
    }

    public boolean existsById(int id) {
        return users.containsKey(id);
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
}
