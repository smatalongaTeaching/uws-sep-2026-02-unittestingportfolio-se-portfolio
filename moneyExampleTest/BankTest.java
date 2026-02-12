package moneyExampleTest;

import org.junit.jupiter.api.Test;

import moneyExample.Bank;
import moneyExample.Expression;
import moneyExample.Money;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void testAddSameCurrency() {
        Bank bank = new Bank();
        Money result = bank.convert(Money.dollar(5), "USD");
        assertEquals(Money.dollar(5), result);
    }

    @Test
    void testConvertDifferentCurrencyUsingRate() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Money result = bank.convert(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    void testAdditionSameCurrency() {
        Bank bank = new Bank();

        Expression sum = Money.dollar(5).plus(Money.dollar(5));
        Money result = bank.convert(sum, "USD");

        assertEquals(Money.dollar(10), result);
    }

    @Test
    void testAdditionDifferentCurrencies() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Expression sum = Money.dollar(5).plus(Money.franc(10));
        Money result = bank.convert(sum, "USD");

        assertEquals(Money.dollar(10), result);
    }

    @Test
    void testSumPlusMoney() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Expression sum = Money.dollar(5).plus(Money.franc(10)).plus(Money.dollar(5));
        Money result = bank.convert(sum, "USD");

        assertEquals(Money.dollar(15), result);
    }

    @Test
    void testSumOfSumsDifferentCurrencies() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Expression sum1 = Money.dollar(5).plus(Money.franc(10));  
        Expression sum2 = Money.dollar(5).plus(Money.franc(10));  

        Expression complex = sum1.plus(sum2); 
        Money result = bank.convert(complex, "USD");

        assertEquals(Money.dollar(20), result);
    }

    @Test
    void testMultiplySumSameCurrency() {
        Bank bank = new Bank();

        Expression sum = Money.dollar(5).plus(Money.dollar(5)); 
        Expression product = sum.times(2);

        Money result = bank.convert(product, "USD");
        assertEquals(Money.dollar(20), result);
    }

    @Test
    void testMixedOperationsDifferentCurrencies() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);

        Expression expr =
            Money.dollar(5)
                .plus(Money.franc(10))
                .times(2) 
                .plus(Money.dollar(5)); 

        Money result = bank.convert(expr, "USD");
        assertEquals(Money.dollar(25), result);
    }

    @Test
    void testZeroAmountAddition() {
        Bank bank = new Bank();
        Money result = bank.convert(Money.dollar(0).plus(Money.dollar(0)), "USD");
        assertEquals(Money.dollar(0), result);
    }

    @Test
    void testEqualExchangeRateDoesNotChangeAmount() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 1);
        Money result = bank.convert(Money.franc(5), "USD");
        assertEquals(Money.dollar(5), result);
    }


}
