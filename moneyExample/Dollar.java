package moneyExample;

public class Dollar {
    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Dollar multiplyDollar(int multiplier) {
        return new Dollar(amount * multiplier); 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dollar dollar = (Dollar) obj;
        return amount == dollar.amount;
    }

    @Override
    public String toString() {
        return "$" + amount;
    }
}