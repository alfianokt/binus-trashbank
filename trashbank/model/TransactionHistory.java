package trashbank.model;

public class TransactionHistory {
    private TransactionType type;
    private int amount;

    public TransactionHistory(TransactionType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public TransactionType getType() {
        return this.type;
    }

    public int getAmount() {
        return this.amount;
    }
}