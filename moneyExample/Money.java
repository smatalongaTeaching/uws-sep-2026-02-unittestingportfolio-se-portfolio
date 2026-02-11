package moneyExample;

public abstract class Money {

    protected final int amount;

    protected Money(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public abstract String getCurrency();
}

