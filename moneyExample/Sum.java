package moneyExample;

public class Sum implements Expression {

    private final Expression augend;
    private final Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(Bank bank, String toCurrency) {
        Money a = bank.convert(augend, toCurrency);
        Money b = bank.convert(addend, toCurrency);

        int total = a.getAmount() + b.getAmount();

        if ("USD".equals(toCurrency)) return Money.dollar(total);
        if ("CHF".equals(toCurrency)) return Money.franc(total);

        throw new IllegalArgumentException("Unsupported currency: " + toCurrency);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }


}
