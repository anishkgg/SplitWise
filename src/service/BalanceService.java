package service;

import model.Balance;
import model.Expense;
import repository.ExpenseRepository;
import repository.GroupRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceService {
    private final ExpenseRepository expenseRepository;
    private final GroupRepository groupRepository;

    public BalanceService(ExpenseRepository expenseRepository, GroupRepository groupRepository) {
        this.expenseRepository = expenseRepository;
        this.groupRepository = groupRepository;
    }

    public List<Balance> calculateBalances(int groupId) {
        if (!groupRepository.existsById(groupId)) {
            throw new IllegalArgumentException("Group does not exist: " + groupId);
        }

        Map<Integer, Integer> netBalances = new HashMap<>();
        List<Expense> expenses = expenseRepository.findByGroupId(groupId);

        for (Expense expense : expenses) {
            netBalances.put(
                    expense.getPaidByUserId(),
                    netBalances.getOrDefault(expense.getPaidByUserId(), 0) + expense.getAmount()
            );

            for (Map.Entry<Integer, Integer> split : expense.getSplitAmounts().entrySet()) {
                int userId = split.getKey();
                int share = split.getValue();
                netBalances.put(userId, netBalances.getOrDefault(userId, 0) - share);
            }
        }

        return simplifyBalances(netBalances);
    }

    private List<Balance> simplifyBalances(Map<Integer, Integer> netBalances) {
        List<Map.Entry<Integer, Integer>> debtors = new ArrayList<>();
        List<Map.Entry<Integer, Integer>> creditors = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : netBalances.entrySet()) {
            if (entry.getValue() < 0) {
                debtors.add(entry);
            } else if (entry.getValue() > 0) {
                creditors.add(entry);
            }
        }

        List<Balance> balances = new ArrayList<>();
        int debtorIndex = 0;
        int creditorIndex = 0;

        while (debtorIndex < debtors.size() && creditorIndex < creditors.size()) {
            Map.Entry<Integer, Integer> debtor = debtors.get(debtorIndex);
            Map.Entry<Integer, Integer> creditor = creditors.get(creditorIndex);

            int amountOwed = -debtor.getValue();
            int amountToReceive = creditor.getValue();
            int settlementAmount = Math.min(amountOwed, amountToReceive);

            balances.add(new Balance(debtor.getKey(), creditor.getKey(), settlementAmount));

            debtor.setValue(debtor.getValue() + settlementAmount);
            creditor.setValue(creditor.getValue() - settlementAmount);

            if (debtor.getValue() == 0) {
                debtorIndex++;
            }
            if (creditor.getValue() == 0) {
                creditorIndex++;
            }
        }

        return balances;
    }
}
