
package moneyExample;

import java.beans.Transient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


public class MoneyTest {

    @Test
    public void testMoneyCreation() {
        Money money = new Money(100, "USD");
        assert money.getAmount() == 100;
        assert money.currency().equals("USD");
    }

    @Test
    public void testMoneyCurrencyUSD() {
        Money money = new Money(100, "USD");
        String curr = money.currency();
        assert curr.equals("USD");
    }

        @Test
    public void testMoneyCurrencyCHF() {
        Money money = new Money(100, "CHF");
        String curr = money.currency();
        curr.equals("CHF");
    }

} 