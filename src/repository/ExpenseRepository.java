package repository;

import model.Expense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseRepository {
    private final Map<Integer, Expense> expenses;
    private int nextId;

    public ExpenseRepository() {
        this.expenses = new HashMap<>();
        this.nextId = 1;
    }

    public int getNextId() {
        return nextId++;
    }

    public void save(Expense expense) {
        expenses.put(expense.getId(), expense);
    }

    public Expense findById(int id) {
        return expenses.get(id);
    }

    public List<Expense> findByGroupId(int groupId) {
        List<Expense> groupExpenses = new ArrayList<>();
        for (Expense expense : expenses.values()) {
            if (expense.getGroupId() == groupId) {
                groupExpenses.add(expense);
            }
        }
        return groupExpenses;
    }
}
