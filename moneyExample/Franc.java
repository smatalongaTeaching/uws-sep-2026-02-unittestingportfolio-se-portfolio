package moneyExample;

public class Franc extends Money {

    public Franc(int amount) {
        super(amount, "CHF");
    }

    public Franc multiplyFranc(int multiplier) {
        return new Franc(getAmount() * multiplier);
    }
}