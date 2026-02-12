package moneyExample;

public class Pound extends Money {

    public Pound(int amount) {
        super(amount, "GBP");
    }

    public Pound multiplyPound(int multiplier) {
        return new Pound(getAmount() * multiplier);
    }
}