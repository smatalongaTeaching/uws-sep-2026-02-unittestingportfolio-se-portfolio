package moneyExample;

public class Pound extends Money {

    public Pound(int amount) {
        super(amount);
    }

    public Pound times(int multiplier) {
        return new Pound(amount * multiplier);
    }

    @Override
    public String getCurrency() {
        return "GBP";
    }
}
