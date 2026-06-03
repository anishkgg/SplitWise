package service;

import model.Expense;
import model.Group;
import repository.ExpenseRepository;
import repository.GroupRepository;
import repository.UserRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository, GroupRepository groupRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public Expense addEqualExpense(int groupId, int paidByUserId, int amount, String description, Set<Integer> participantIds) {
        Group group = groupRepository.findById(groupId);
        if (group == null) {
            throw new IllegalArgumentException("Group does not exist: " + groupId);
        }
        if (!userRepository.existsById(paidByUserId)) {
            throw new IllegalArgumentException("Payer does not exist: " + paidByUserId);
        }
        if (!group.getMemberIds().contains(paidByUserId)) {
            throw new IllegalArgumentException("Payer is not part of the group: " + paidByUserId);
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (participantIds == null || participantIds.isEmpty()) {
            throw new IllegalArgumentException("Expense must have at least one participant");
        }

        Set<Integer> uniqueParticipantIds = new HashSet<>(participantIds);
        for (int participantId : uniqueParticipantIds) {
            if (!group.getMemberIds().contains(participantId)) {
                throw new IllegalArgumentException("Participant is not part of the group: " + participantId);
            }
        }

        Map<Integer, Integer> splitAmounts = calculateEqualSplit(amount, uniqueParticipantIds);
        Expense expense = new Expense(
                expenseRepository.getNextId(),
                groupId,
                paidByUserId,
                amount,
                description,
                splitAmounts
        );

        expenseRepository.save(expense);
        group.addExpenseId(expense.getId());
        groupRepository.save(group);
        return expense;
    }

    private Map<Integer, Integer> calculateEqualSplit(int amount, Set<Integer> participantIds) {
        Map<Integer, Integer> splitAmounts = new HashMap<>();
        int baseShare = amount / participantIds.size();
        int remainder = amount % participantIds.size();

        for (int participantId : participantIds) {
            int share = baseShare;
            if (remainder > 0) {
                share++;
                remainder--;
            }
            splitAmounts.put(participantId, share);
        }

        return splitAmounts;
    }
}
