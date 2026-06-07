package service;

import model.Expense;
import model.Group;
import model.User;
import repository.ExpenseRepository;
import repository.GroupRepository;
import repository.UserRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public Expense addEqualExpense(int groupId, int paidByUserId, int amount, String description, Set<Integer> participantIds) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("Group does not exist: " + groupId));
        
        User payer = userRepository.findById(paidByUserId)
                .orElseThrow(() -> new IllegalArgumentException("Payer does not exist: " + paidByUserId));

        // Check if payer is part of the group
        boolean isPayerInGroup = group.getMembers().stream()
                .anyMatch(member -> member.getId() == paidByUserId);
        
        if (!isPayerInGroup) {
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
            boolean isParticipantInGroup = group.getMembers().stream()
                    .anyMatch(member -> member.getId() == participantId);
            if (!isParticipantInGroup) {
                throw new IllegalArgumentException("Participant is not part of the group: " + participantId);
            }
        }

        Map<Integer, Integer> splitAmounts = calculateEqualSplit(amount, uniqueParticipantIds);
        
        Expense expense = new Expense();
        expense.setGroup(group);
        expense.setPayer(payer);
        expense.setAmount(amount);
        expense.setDescription(description);
        expense.setSplitAmounts(splitAmounts);

        Expense savedExpense = expenseRepository.save(expense);
        
        group.addExpense(savedExpense);
        groupRepository.save(group);
        
        return savedExpense;
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
