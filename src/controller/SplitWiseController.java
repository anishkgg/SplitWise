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

<<<<<<< HEAD
    Scanner scn;
    UserService userService;
    TransactionService transactionService;
    GroupService groupService;

    public SplitWiseController() {
        this.scn = new Scanner(System.in);
        this.groupService = new GroupService();
        this.transactionService = new TransactionService();
        this.userService = new UserService();
    }


    public void startProgram() {
        while (true) {
            System.out.println("Hey What you want to do ? Select below options");
            System.out.println(
                    "1. create-group\n" +
                            "2. Do transaction in a group\n" +
                            "3. create user\n" +
                            "4. Show which users owes how much amount in the group and whom he owes");
            int opt = scn.nextInt();
            if (opt == 1) {
                System.out.println("User selected opt 1 i.e. group");
                groupService.createGroup(scn);
                System.out.println("Group created successfully");
            } else if (opt == 2) {

            } else if (opt == 3) {

            } else if (opt == 4) {

            } else {
                System.out.println("Wrong option entered. Enter value again");
                continue;
            }

            System.out.println("Are you satisfied?(Yes/No)");
        }
=======
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
>>>>>>> 5ea9fdbd11a9c54d74dba6064e23529a2d24aacf
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
