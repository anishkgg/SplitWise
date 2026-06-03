package model;

import java.util.HashMap;
import java.util.Map;

public class Expense {
    private int id;
    private int groupId;
    private int paidByUserId;
    private int amount;
    private String description;
    private Map<Integer, Integer> splitAmounts;

    public Expense(int id, int groupId, int paidByUserId, int amount, String description, Map<Integer, Integer> splitAmounts) {
        this.id = id;
        this.groupId = groupId;
        this.paidByUserId = paidByUserId;
        this.amount = amount;
        this.description = description;
        this.splitAmounts = new HashMap<>(splitAmounts);
    }

    public int getId() {
        return id;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getPaidByUserId() {
        return paidByUserId;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Map<Integer, Integer> getSplitAmounts() {
        return splitAmounts;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", paidByUserId=" + paidByUserId +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", splitAmounts=" + splitAmounts +
                '}';
    }
}
