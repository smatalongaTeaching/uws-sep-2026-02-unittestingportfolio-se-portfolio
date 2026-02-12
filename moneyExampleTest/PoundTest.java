package moneyExampleTest;

import org.junit.jupiter.api.Test;

import moneyExample.Pound;

import static org.junit.jupiter.api.Assertions.*;

class PoundTest {

    @Test
    void testCreatePound() {
        Pound five = new Pound(5);
        assertEquals(5, five.getAmount());
    }

    @Test
    void testPoundMultiplication() {
        Pound five = new Pound(5);
        Pound result = five.times(2);
        assertEquals(10, result.getAmount());
    }

    @Test
    void testPoundIsImmutable() {
        Pound five = new Pound(5);
        five.times(2);
        assertEquals(5, five.getAmount());
    }

    @Test
    void testPoundEquality() {
        assertEquals(new Pound(5), new Pound(5));
        assertNotEquals(new Pound(5), new Pound(6));
    }

    @Test
    void testTimesReturnsNewObject() {
        Pound five = new Pound(5);
        Pound result = five.times(2);
        assertNotSame(five, result);
    }

}
