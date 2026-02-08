package moneyExample;

public class Franc {
    private int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Franc multiplyFranc(int multiplier) {
        return new Franc(amount * multiplier); 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Franc franc = (Franc) obj;
        return amount == franc.amount;
    }

    @Override
    public String toString() {
        return "$" + amount;
    }
}