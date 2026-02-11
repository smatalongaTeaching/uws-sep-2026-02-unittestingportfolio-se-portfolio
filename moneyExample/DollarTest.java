package moneyExample;

import org.junit.jupiter.api.Test;
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

}
