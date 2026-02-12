package moneyExampleTest;

import org.junit.jupiter.api.Test;
<<<<<<< HEAD

import moneyExample.Dollar;
=======
import moneyExample.Dollar;
import moneyExample.Franc; 
import moneyExample.Money; 
import moneyExample.Pound; 
import java.util.ArrayList;
>>>>>>> B01787017-Dean-Cain

import static org.junit.jupiter.api.Assertions.*;

class DollarTest {

    @Test
    void testCreateDollar() {
        Dollar five = new Dollar(5);
        assertEquals(5, five.getAmount());
    }

    @Test
    void testDollarMultiplication() {
        Dollar five = new Dollar(5);
        Dollar result = five.times(2);
        assertEquals(10, result.getAmount());
    }

    @Test
    void testDollarIsImmutable() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(5, five.getAmount());
    }

    @Test
    void testDollarEquality() {
        assertEquals(new Dollar(5), new Dollar(5));
        assertNotEquals(new Dollar(5), new Dollar(6));
    }

    @Test
    void testTimesReturnsNewObject() {
        Dollar five = new Dollar(5);
        Dollar result = five.times(2);
        assertNotSame(five, result);
    }

    @Test
    void testExampleForLiskovSubstitution() {
        ArrayList<Money> monies = new ArrayList<Money>();
        monies.add(new Dollar(23));
        monies.add(new Franc(23));
        monies.add(new Pound(23));

        for (Money money : monies) {
            System.out.println(money.getAmount() + "-" + money.getCurrency());
        }

    }

}
