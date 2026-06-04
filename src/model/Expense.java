package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    private int id;
    private int groupId;
    private int paidByUserId;
    private int amount;
    private String description;
    private Map<Integer, Integer> splitAmounts;
}
