package moneyExampleTest;

import org.junit.jupiter.api.Test;

import moneyExample.Dollar;
import moneyExample.Franc;
import moneyExample.Money;

import static org.junit.jupiter.api.Assertions.*;

class MoneyCurrencyTest {

    @Test
    void testDollarCurrency() {
        assertEquals("USD", new Dollar(1).getCurrency());
    }

    @Test
    void testFrancCurrency() {
        assertEquals("CHF", new Franc(1).getCurrency());
    }

    @Test
    void testDollarCreatesCorrectAmount() {
        Money usd = Money.dollar(5);
        assertEquals(5, usd.getAmount());
    }

    @Test
    void testDollarSetsCorrectCurrency() {
        Money usd = Money.dollar(5);
        assertEquals("USD", usd.getCurrency());
    }

    @Test
    void testFrancCreatesCorrectAmount() {
        Money chf = Money.franc(5);
        assertEquals(5, chf.getAmount());
    }

    @Test
    void testFrancSetsCorrectCurrency() {
        Money chf = Money.franc(5);
        assertEquals("CHF", chf.getCurrency());
    }

    @Test
    void testEquality() {
        assertEquals(Money.dollar(5), new Dollar(5));
        assertEquals(Money.franc(5), new Franc(5));
    }

    @Test
    void testDifferentCurrenciesNotEqual() {
        assertNotEquals(Money.dollar(5), Money.franc(5));
    }



}
