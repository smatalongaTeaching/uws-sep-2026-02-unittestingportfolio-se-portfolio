package moneyExample;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Double> rates = new HashMap<>();

    public Money reduce(Expression source, String toCurrency) { 
        return source.reduce(this, toCurrency); 
    }

    public void addRate(String from, String to, double rate) {
        rates.put(from + "-" + to, rate);
    }

    public double getRate(String from, String to) {
     if (from.equals(to)) return 1.0; 
     return rates.get(from + "-" + to); 
    }
}

