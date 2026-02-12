package moneyExample;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Integer> rates = new HashMap<>();

    public void addRate(String fromCurrency, String toCurrency, int rate) {
        rates.put(key(fromCurrency, toCurrency), rate);
    }

    public Money convert(Money source, String toCurrency) {

        // Same-currency: no conversion required
        if (source.getCurrency().equals(toCurrency)) {
            return source;
        }

        Integer rate = rates.get(key(source.getCurrency(), toCurrency));
        if (rate == null) {
            throw new IllegalArgumentException(
                "Missing exchange rate: " + source.getCurrency() + "->" + toCurrency
            );
        }

        int convertedAmount = source.getAmount() / rate;

        // Create target Money type
        if ("USD".equals(toCurrency)) return Money.dollar(convertedAmount);
        if ("CHF".equals(toCurrency)) return Money.franc(convertedAmount);
        if ("GBP".equals(toCurrency)) return Money.pound(convertedAmount);

        throw new IllegalArgumentException("Unsupported currency: " + toCurrency);
    }

    private String key(String fromCurrency, String toCurrency) {
        return fromCurrency + "->" + toCurrency;
    }

    public Money convert(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }


}
