package controller;

import lombok.RequiredArgsConstructor;
import model.Balance;
import model.Expense;
import model.Group;
import model.User;
import org.springframework.web.bind.annotation.*;
import service.BalanceService;
import service.ExpenseService;
import service.GroupService;
import service.UserService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SplitWiseController {

    private final UserService userService;
    private final GroupService groupService;
    private final ExpenseService expenseService;
    private final BalanceService balanceService;

    @PostMapping("/users")
    public User createUser(@RequestParam String name) {
        return userService.createUser(name);
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/groups")
    public Group createGroup(@RequestParam String name, @RequestBody Set<Integer> memberIds) {
        return groupService.createGroup(name, memberIds);
    }

    @GetMapping("/groups/{groupId}")
    public Group getGroupById(@PathVariable int groupId) {
        return groupService.getGroupById(groupId);
    }

    @GetMapping("/groups")
    public List<Group> getGroups() {
        return groupService.getAllGroups();
    }

    @PostMapping("/expenses")
    public Expense addEqualExpense(
            @RequestParam int groupId,
            @RequestParam int paidByUserId,
            @RequestParam int amount,
            @RequestParam String description,
            @RequestBody Set<Integer> participantIds
    ) {
        return expenseService.addEqualExpense(groupId, paidByUserId, amount, description, participantIds);
    }

    @GetMapping("/groups/{groupId}/balances")
    public List<Balance> getGroupBalances(@PathVariable int groupId) {
        return balanceService.calculateBalances(groupId);
    }
}
