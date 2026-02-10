package moneyExample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class Stage4IndividualTests {

    private Bank bank;
    private Money fiveBucks;
    private Money tenFrancs;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        bank.addRate("CHF", "USD", 0.5); 
        
        bank.addRate("JPY", "USD", 0.01);

        fiveBucks = Money.dollar(5);
        tenFrancs = Money.franc(10);
    }

    @Test
    void testSumOfSums() {
        // (5 USD + 10 CHF) + 5 USD = 15 USD
        Expression sum1 = new Sum(fiveBucks, tenFrancs);
        Expression sum2 = new Sum(sum1, fiveBucks);
        Money result = bank.reduce(sum2, "USD");
        assertEquals(Money.dollar(15), result);
    }

    @Test
    void testMultiplicationOfSums() {
        // (5 USD + 10 CHF) * 2 = 20 USD
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }

    @Test
    void testMixedOperations() {
        // {(5 USD + 10 CHF) * 2} + 5 USD = 25 USD
        Expression complex = new Sum(new Sum(fiveBucks, tenFrancs).times(2), fiveBucks);
        Money result = bank.reduce(complex, "USD");
        assertEquals(Money.dollar(25), result);
    }

    @Test
    void testComplexMultipleCurrencies() {
        // 5 USD + 10 CHF + 200 JPY (where 100 JPY = 1 USD)
        bank.addRate("JPY", "USD", 0.01);
        Expression mixed = new Sum(new Sum(fiveBucks, tenFrancs), Money.currency(200, "JPY"));
        Money result = bank.reduce(mixed, "USD");
        // 5 + 5 + 2 = 12 USD
        assertEquals(Money.dollar(12), result);
    }

    @Test
    void testEdgeCaseZeroAmounts() {
        Expression zeroSum = new Sum(Money.dollar(0), Money.franc(0));
        Money result = bank.reduce(zeroSum, "USD");
        assertEquals(Money.dollar(0), result);
    }

    @Test
    void testEqualExchangeRates() {
        // If 1 GBP = 1 USD, result should be a simple sum
        bank.addRate("GBP", "USD", 1);
        Expression equalSum = new Sum(fiveBucks, Money.currency(5, "GBP"));
        Money result = bank.reduce(equalSum, "USD");
        assertEquals(Money.dollar(10), result);
    }
}
