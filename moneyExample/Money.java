package moneyExample;

import java.util.Objects;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    protected Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

        public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public int getAmount() {
        return amount;
    }

    public String currency() {
        return currency;
    }

    public static Money currency(int amount, String currency) {
        return new Money(amount, currency);
    }

    @Override
    public Money reduce(Bank bank, String toCurrency) {
        if (currency.equals(toCurrency)) {
            return this;
        }

        double rate = bank.getRate(currency, toCurrency);
        int converted = (int) (amount * rate);

        return new Money(converted, toCurrency);
    }

public Expression times(int multiplier) {
    return new Money(amount * multiplier, currency);
}

    public static Money dollar(int amount) {
        return new Dollar(amount);
    }

    public static Money franc(int amount) {
        return new Franc(amount);
    }

    public static Money pound(int amount) {
        return new Pound(amount);
    }

    public static Money create(int amount, String currency) {
        if ("USD".equals(currency)) return new Dollar(amount);
        if ("CHF".equals(currency)) return new Franc(amount);
        if ("GBP".equals(currency)) return new Pound(amount);
        return new Money(amount, currency);
    }

    @Override
    public String toString() {
        String symbol = switch (currency) {
            case "USD" -> "$";
            case "CHF" -> "Fr";
            case "GBP" -> "£";
            default -> currency;
        };
        return symbol + amount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Money)) return false;
        Money money = (Money) object;
        return amount == money.amount && currency().equals(money.currency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}
