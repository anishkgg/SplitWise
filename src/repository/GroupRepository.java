package repository;

import model.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupRepository {
    private final Map<Integer, Group> groups;
    private int nextId;

    public GroupRepository() {
        this.groups = new HashMap<>();
        this.nextId = 1;
    }

    public int getNextId() {
        return nextId++;
    }

    public void save(Group group) {
        groups.put(group.getId(), group);
    }

    public Group findById(int id) {
        return groups.get(id);
    }

    public boolean existsById(int id) {
        return groups.containsKey(id);
    }

    public List<Group> findAll() {
        return new ArrayList<>(groups.values());
    }
}
