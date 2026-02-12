package moneyExample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FrancTest {

    @Test
    void testCreateFranc() {
        Franc five = new Franc(5);
        assertEquals(5, five.getAmount());
    }

    @Test
    void testFrancMultiplication() {
        Franc five = new Franc(5);
        Franc result = five.times(2);
        assertEquals(10, result.getAmount());
    }

    @Test
    void testFrancIsImmutable() {
        Franc five = new Franc(5);
        five.times(2);
        assertEquals(5, five.getAmount());
    }

    @Test
    void testFrancEquality() {
        assertEquals(new Franc(5), new Franc(5));
        assertNotEquals(new Franc(5), new Franc(6));
    }

    @Test
    void testTimesReturnsNewObject() {
        Franc five = new Franc(5);
        Franc result = five.times(2);
        assertNotSame(five, result);
    }

}
