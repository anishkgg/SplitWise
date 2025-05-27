package model;

import java.util.HashMap;
import java.util.HashSet;

public class Transaction {
    int id;
    int groupId;
    int amount;
    User payee;
    String operation;
    HashMap<Integer, Integer> owes;

    public Transaction(int id, int groupId, int amount, User payee, String operation, HashMap<Integer, Integer> owes) {
        this.id = id;
        this.groupId = groupId;
        this.amount = amount;
        this.payee = payee;
        this.operation = operation;
        this.owes = owes;
    }

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getPayee() {
        return payee;
    }

    public void setPayee(User payee) {
        this.payee = payee;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public HashMap<Integer, Integer> getOwes() {
        return owes;
    }

    public void setOwes(HashMap<Integer, Integer> owes) {
        this.owes = owes;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", amount=" + amount +
                ", payee=" + payee +
                ", operation='" + operation + '\'' +
                ", owes=" + owes +
                '}';
    }
}