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

    public static Money dollar(int amount) {
        return new Dollar(amount);
    }

    public static Money franc(int amount) {
        return new Franc(amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Money)) return false;
        Money other = (Money) obj;
        return amount == other.amount && getCurrency().equals(other.getCurrency());
    }

}

