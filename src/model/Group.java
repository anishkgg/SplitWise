package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    private int id;
    private String name;
    private Set<Integer> memberIds;
    private List<Integer> expenseIds;

    public Group(int id, String name, Set<Integer> memberIds) {
        this.id = id;
        this.name = name;
        this.memberIds = new HashSet<>(memberIds);
        this.expenseIds = new ArrayList<>();
    }

    public Group() {
        this.memberIds = new HashSet<>();
        this.expenseIds = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(Set<Integer> memberIds) {
        this.memberIds = memberIds;
    }

    public List<Integer> getExpenseIds() {
        return expenseIds;
    }

    public void setExpenseIds(List<Integer> expenseIds) {
        this.expenseIds = expenseIds;
    }

    public void addExpenseId(int expenseId) {
        this.expenseIds.add(expenseId);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", memberIds=" + memberIds +
                ", expenseIds=" + expenseIds +
                '}';
    }
}
