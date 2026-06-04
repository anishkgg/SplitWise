package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private int id;
    private String name;
    private Set<Integer> memberIds = new HashSet<>();
    private List<Integer> expenseIds = new ArrayList<>();

    public Group(int id, String name, Set<Integer> memberIds) {
        this.id = id;
        this.name = name;
        this.memberIds = new HashSet<>(memberIds);
        this.expenseIds = new ArrayList<>();
    }

    public void addExpenseId(int expenseId) {
        this.expenseIds.add(expenseId);
    }
}
