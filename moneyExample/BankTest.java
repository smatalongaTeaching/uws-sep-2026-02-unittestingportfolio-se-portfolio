package moneyExample;

import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void testConversion() {  
        Bank bank = new Bank();
        bank.addRate("GBP", "USD", 1.75);
        
        Money result = bank.reduce(new Money(100, "GBP"), "USD");
        
        assert result.getAmount() == 175;
        assert result.currency().equals("USD");
    }

    @Test
    public void testAddSameCurrency() {
        Bank bank = new Bank();
        
        Money result = bank.reduce(new Money(100, "USD"), "USD");
        
        assert result.getAmount() == 100;
        assert result.currency().equals("USD");
    }

    @Test
        public void testAddDifferentCurrencies() {
            Bank bank = new Bank();
            bank.addRate("GBP", "USD", 1.5);
            
            Money money1 = new Money(100, "USD");
            Money money2 = new Money(50, "GBP");

            Expression result = money1.plus(money2);
            Money reduced = result.reduce(bank, "USD");
            
            assert reduced.getAmount() == 175;
            assert reduced.currency().equals("USD");
        }
}
