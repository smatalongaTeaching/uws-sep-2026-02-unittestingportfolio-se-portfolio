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
        Money reducedAugend = bank.convert((Money) augend, toCurrency);
        Money reducedAddend = bank.convert((Money) addend, toCurrency);

        int total = reducedAugend.getAmount() + reducedAddend.getAmount();

        if ("USD".equals(toCurrency)) return Money.dollar(total);
        if ("CHF".equals(toCurrency)) return Money.franc(total);

        throw new IllegalArgumentException("Unsupported currency");
    }
}
