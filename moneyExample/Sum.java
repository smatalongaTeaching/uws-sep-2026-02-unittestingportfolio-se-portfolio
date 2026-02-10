package moneyExample;

public class Sum implements Expression {
    private Expression left;
    private Expression right;

    public Sum(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

@Override
public Money reduce(Bank bank, String currency) {
    Money reducedLeft = left.reduce(bank, currency);
    Money reducedRight = right.reduce(bank, currency);
    return new Money(reducedLeft.getAmount() + reducedRight.getAmount(), currency);
}

}
