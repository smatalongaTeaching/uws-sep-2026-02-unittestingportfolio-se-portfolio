
package moneyExample;

import java.beans.Transient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


public class FrancTest {

    @Test
    public void testMoneyCreation() {
        Franc franc = new Franc(100);
        assert franc.getAmount() == 100;
        assert franc.toString().equals("Fr100");
    }

    @Test
    public void testMoneyMultiplication() {
        Franc franc = new Franc(100);
        Franc doubled = franc.multiplyFranc(2);
        assert doubled.getAmount() == 200;
    }   
    @Test
    public void testFrancEquality() {
        Franc franc1 = new Franc(5);
        Franc franc2 = new Franc(5);
        assert franc1.equals(franc2); 
    }

    @Test
    public void testFrancInequality() {
        Franc franc1 = new Franc(5);
        Franc franc2 = new Franc(10);
        assert !franc1.equals(franc2); 
    }

    @Test
    public void testFrancImmutability() {
    Franc original = new Franc(5);
    Franc doubled = original.multiplyFranc(2);
    
    assert original.getAmount() == 5;
    
    assert doubled.getAmount() == 10;

    assert original != doubled; 
}
}