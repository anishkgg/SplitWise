package controller;

import model.Balance;
import model.Expense;
import model.Group;
import model.User;
import repository.ExpenseRepository;
import repository.GroupRepository;
import repository.UserRepository;
import service.BalanceService;
import service.ExpenseService;
import service.GroupService;
import service.UserService;

import java.util.List;
import java.util.Set;

public class SplitWiseController {

    private final UserService userService;
    private final GroupService groupService;
    private final ExpenseService expenseService;
    private final BalanceService balanceService;

    public SplitWiseController() {
        UserRepository userRepository = new UserRepository();
        GroupRepository groupRepository = new GroupRepository();
        ExpenseRepository expenseRepository = new ExpenseRepository();

        this.userService = new UserService(userRepository);
        this.groupService = new GroupService(groupRepository, userRepository);
        this.expenseService = new ExpenseService(expenseRepository, groupRepository, userRepository);
        this.balanceService = new BalanceService(expenseRepository, groupRepository);
    }

    public User createUser(String name) {
        return userService.createUser(name);
    }

    public User getUserById(int userId) {
        return userService.getUserById(userId);
    }

    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    public Group createGroup(String name, Set<Integer> memberIds) {
        return groupService.createGroup(name, memberIds);
    }

    public Group getGroupById(int groupId) {
        return groupService.getGroupById(groupId);
    }

    public List<Group> getGroups() {
        return groupService.getAllGroups();
    }

    public Expense addEqualExpense(
            int groupId,
            int paidByUserId,
            int amount,
            String description,
            Set<Integer> participantIds
    ) {
        return expenseService.addEqualExpense(groupId, paidByUserId, amount, description, participantIds);
    }

    public List<Balance> getGroupBalances(int groupId) {
        return balanceService.calculateBalances(groupId);
    }
}
