package service;

import model.Group;
import repository.GroupRepository;
import repository.UserRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        Set<Integer> uniqueMemberIds = new HashSet<>(memberIds);
        for (int userId : uniqueMemberIds) {
            if (!userRepository.existsById(userId)) {
                throw new IllegalArgumentException("User does not exist: " + userId);
            }
        }

        Group group = new Group(groupRepository.getNextId(), name.trim(), uniqueMemberIds);
        groupRepository.save(group);
        return group;
    }

    public Group getGroupById(int groupId) {
        Group group = groupRepository.findById(groupId);
        if (group == null) {
            throw new IllegalArgumentException("Group does not exist: " + groupId);
        }
        return group;
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }
}
