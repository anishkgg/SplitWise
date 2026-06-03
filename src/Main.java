import controller.SplitWiseController;
import model.Balance;
import model.Group;
import model.User;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        SplitWiseController splitWiseController = new SplitWiseController();

        User alice = splitWiseController.createUser("Alice");
        User bob = splitWiseController.createUser("Bob");
        Group trip = splitWiseController.createGroup("Trip", Set.of(alice.getId(), bob.getId()));

        splitWiseController.addEqualExpense(
                trip.getId(),
                alice.getId(),
                1000,
                "Hotel",
                Set.of(alice.getId(), bob.getId())
        );

        List<Balance> balances = splitWiseController.getGroupBalances(trip.getId());
        System.out.println(balances);
    }
}
