
package moneyExample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MoneyTest {

    @Test
    public void testMoneyCreation() {
        Money money = new Money(100, "USD");
        assertEquals(100, money.getAmount());
        assertEquals("USD", money.getCurrency());
    }

    @Test
    public void testMoneyAdditionofTwoCurencies() {
        Money money1 = new Money(100, "USD");
        Money money2 = new Money(50, "GBP");
        Money result = money1.add(money2);        
        assertEquals(175, result.getAmount());
        assertEquals("USD", result.getCurrency());
    }
}