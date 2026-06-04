package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@Table(name = "expenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private User payer;

    private int amount;
    private String description;

    @ElementCollection
    @CollectionTable(name = "expense_splits", joinColumns = @JoinColumn(name = "expense_id"))
    @MapKeyColumn(name = "user_id")
    @Column(name = "amount")
    private Map<Integer, Integer> splitAmounts;
}
