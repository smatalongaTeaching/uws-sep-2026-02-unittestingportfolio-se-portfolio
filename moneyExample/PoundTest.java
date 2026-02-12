
package moneyExample;

import org.junit.jupiter.api.Test;

public class PoundTest {

    @Test
    public void testMoneyCreation() {
        Pound pound = new Pound(100);
        assert pound.getAmount() == 100;
        assert pound.toString().equals("£100");
    }

    @Test
    public void testMoneyMultiplication() {
        Pound pound = new Pound(100);
        Pound doubled = pound.multiplyPound(2);
        assert doubled.getAmount() == 200;
    }   
    @Test
    public void testPoundEquality() {
        Pound pound1 = new Pound(5);
        Pound pound2 = new Pound(5);
        assert pound1.equals(pound2); 
    }

    @Test
    public void testPoundInequality() {
        Pound pound1 = new Pound(5);
        Pound pound2 = new Pound(10);
        assert !pound1.equals(pound2); 
    }

    @Test
    public void testPoundImmutability() {
    Pound original = new Pound(5);
    Pound doubled = original.multiplyPound(2);
    
    assert original.getAmount() == 5;
    
    assert doubled.getAmount() == 10;

    assert original != doubled; 
}
}