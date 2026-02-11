package moneyExample;

import org.junit.jupiter.api.Test;
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

}
