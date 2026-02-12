package moneyExampleTest;

import org.junit.jupiter.api.Test;

import moneyExample.Dollar;
import moneyExample.Franc;
import moneyExample.Money;

import static org.junit.jupiter.api.Assertions.*;

class MoneySuperClassTest {

    @Test
    void testDollarIsMoney() {
        Money money = new Dollar(5);
        assertEquals(5, money.getAmount());
    }

    @Test
    void testFrancIsMoney() {
        Money money = new Franc(5);
        assertEquals(5, money.getAmount());
    }
}
