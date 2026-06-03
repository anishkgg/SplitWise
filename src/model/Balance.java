package model;

public class Balance {
    private int fromUserId;
    private int toUserId;
    private int amount;

    public Balance(int fromUserId, int toUserId, int amount) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.amount = amount;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public int getToUserId() {
        return toUserId;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "fromUserId=" + fromUserId +
                ", toUserId=" + toUserId +
                ", amount=" + amount +
                '}';
    }
}
