package moneyExample;

public abstract class Money implements Expression {

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

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(Bank bank, String toCurrency) {
        return bank.convert(this, toCurrency);
    }

    @Override
    public Expression times(int multiplier) {
        if ("USD".equals(getCurrency())) return Money.dollar(amount * multiplier);
        if ("CHF".equals(getCurrency())) return Money.franc(amount * multiplier);
        throw new IllegalArgumentException("Unsupported currency: " + getCurrency());
    }


}

