package model;

import java.util.HashSet;
import java.util.List;

public class Group {
    int id;
    HashSet<Integer> users;
    List<Transaction> transactions;

    public Group(int id, HashSet<Integer> users, List<Transaction> transactions) {
        this.id = id;
        this.users = users;
        this.transactions = transactions;
    }

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashSet<Integer> getUsers() {
        return users;
    }

    public void setUsers(HashSet<Integer> users) {
        this.users = users;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", users=" + users +
                ", transactions=" + transactions +
                '}';
    }
}