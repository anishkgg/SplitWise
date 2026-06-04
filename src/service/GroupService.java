package service;

import model.Group;
import model.User;
import repository.GroupRepository;
import repository.UserRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public Group createGroup(String name, Set<Integer> memberIds) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Group name cannot be empty");
        }
        if (memberIds == null || memberIds.isEmpty()) {
            throw new IllegalArgumentException("Group must have at least one user");
        }

        Set<User> members = memberIds.stream()
                .map(id -> userRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("User does not exist: " + id)))
                .collect(Collectors.toSet());

        Group group = new Group();
        group.setName(name.trim());
        group.setMembers(members);
        
        return groupRepository.save(group);
    }

    public Group getGroupById(int groupId) {
        return groupRepository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("Group does not exist: " + groupId));
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }
}
