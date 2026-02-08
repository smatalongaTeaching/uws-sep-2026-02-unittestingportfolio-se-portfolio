package moneyExample;

public class Dollar extends Money {

    public Dollar(int amount) {
        super(amount, "USD");
    }

    public Dollar multiplyDollar(int multiplier) {
        return new Dollar(getAmount() * multiplier);
    }
}