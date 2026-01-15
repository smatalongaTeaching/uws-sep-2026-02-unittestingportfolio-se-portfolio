
package moneyExample;

import java.beans.Transient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


public class MoneyTest {

    @Test
    public void testMoneyCreation() {
        Money money = new Money(100, "USD");
        assert money.getAmount() == 100;
        assert money.getCurrency().equals("USD");
    }

    @Test
    public void testMoneyAdditionofTwoCurencies() {
        Money money1 = new Money(100, "USD");
        Money money2 = new Money(50, "GBP");

        Money result = money1.add(money2);
        
        assert result.getAmount() == 175;
        assert result.getCurrency().equals("USD");
    }
}