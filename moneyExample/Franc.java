package moneyExample;

public class Franc extends Money {

    public Franc(int amount) {
        super(amount);
    }

    public Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }

    @Override
    public String getCurrency() {
        return "CHF";
    }
}
