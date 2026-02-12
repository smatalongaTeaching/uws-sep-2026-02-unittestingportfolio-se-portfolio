
package moneyExample;

import org.junit.jupiter.api.Test;

public class DollarTest {

    @Test
    public void testMoneyCreation() {
        Dollar dollar = new Dollar(100);
        assert dollar.getAmount() == 100;
        assert dollar.toString().equals("$100");
    }

    @Test
    public void testMoneyMultiplication() {
        Dollar dollar = new Dollar(100);
        Dollar doubled = dollar.multiplyDollar(2);
        assert doubled.getAmount() == 200;
    }   
    @Test
    public void testDollarEquality() {
        Dollar dollar1 = new Dollar(5);
        Dollar dollar2 = new Dollar(5);
        assert dollar1.equals(dollar2); 
    }

    @Test
    public void testDollarInequality() {
        Dollar dollar1 = new Dollar(5);
        Dollar dollar2 = new Dollar(10);
        assert !dollar1.equals(dollar2); 
    }

    @Test
    public void testDollarImmutability() {
    Dollar original = new Dollar(5);
    Dollar doubled = original.multiplyDollar(2);
    
    assert original.getAmount() == 5;
    
    assert doubled.getAmount() == 10;

    assert original != doubled;  // Different references in memory
}
}
