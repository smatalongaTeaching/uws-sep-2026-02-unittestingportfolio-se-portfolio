package moneyExample;

import org.junit.jupiter.api.Test;
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


}
