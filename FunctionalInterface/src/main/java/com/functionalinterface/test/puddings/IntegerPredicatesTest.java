package com.functionalinterface.test.puddings;

import org.junit.Test;

// import com.predicate.puddings.IntegerPredicates;
import com.functionalinterface.puddings.IntegerPredicates;

import static org.junit.Assert.*;

/**
 * Tests for {@link IntegerPredicates}.
 */
public final class IntegerPredicatesTest {

    @Test
    public void isEqualTo() {
        assertTrue(IntegerPredicates.isEqualTo(1).test(1));
        assertFalse(IntegerPredicates.isEqualTo(1).test(2));
    }

    @Test
    public void isNotEqualTo() {
        assertFalse(IntegerPredicates.isNotEqualTo(1).test(1));
        assertTrue(IntegerPredicates.isNotEqualTo(1).test(2));
    }

    @Test
    public void IsBiggerThan() {
        assertTrue(IntegerPredicates.isBiggerThan(1).test(2));
        assertFalse(IntegerPredicates.isBiggerThan(1).test(1));
        assertFalse(IntegerPredicates.isBiggerThan(1).test(0));
    }

    @Test
    public void isSmallerThan() {
        assertFalse(IntegerPredicates.isSmallerThan(1).test(2));
        assertFalse(IntegerPredicates.isSmallerThan(1).test(1));
        assertTrue(IntegerPredicates.isSmallerThan(1).test(0));
    }

    @Test
    public void isEqualOrBiggerThan() {
        assertTrue(IntegerPredicates.isEqualOrBiggerThan(1).test(1));
        assertTrue(IntegerPredicates.isEqualOrBiggerThan(1).test(2));
        assertFalse(IntegerPredicates.isEqualOrBiggerThan(1).test(0));
    }

    @Test
    public void isEqualOrSmallerThan() {
        assertTrue(IntegerPredicates.isEqualOrSmallerThan(1).test(1));
        assertFalse(IntegerPredicates.isEqualOrSmallerThan(1).test(2));
        assertTrue(IntegerPredicates.isEqualOrSmallerThan(1).test(0));
    }

    @Test
    public void isInRange() {
        assertTrue(IntegerPredicates.isInRange(0).apply(99).test(99));
        assertTrue(IntegerPredicates.isInRange(0).apply(99).test(0));
        assertTrue(IntegerPredicates.isInRange(0).apply(99).test(50));
        assertFalse(IntegerPredicates.isInRange(0).apply(99).test(100));
        assertFalse(IntegerPredicates.isInRange(0).apply(99).test(-1));

        assertTrue(IntegerPredicates.isInRange(0, 99).test(99));
        assertTrue(IntegerPredicates.isInRange(0, 99).test(0));
        assertTrue(IntegerPredicates.isInRange(0, 99).test(50));
        assertFalse(IntegerPredicates.isInRange(0, 99).test(100));
        assertFalse(IntegerPredicates.isInRange(0, 99).test(-1));
    }

    @Test
    public void isNotInRange() {
        assertFalse(IntegerPredicates.isNotInRange(0).apply(99).test(99));
        assertFalse(IntegerPredicates.isNotInRange(0).apply(99).test(0));
        assertFalse(IntegerPredicates.isNotInRange(0).apply(99).test(50));
        assertTrue(IntegerPredicates.isNotInRange(0).apply(99).test(100));
        assertTrue(IntegerPredicates.isNotInRange(0).apply(99).test(-1));

        assertFalse(IntegerPredicates.isNotInRange(0, 99).test(99));
        assertFalse(IntegerPredicates.isNotInRange(0, 99).test(0));
        assertFalse(IntegerPredicates.isNotInRange(0, 99).test(50));
        assertTrue(IntegerPredicates.isNotInRange(0, 99).test(100));
        assertTrue(IntegerPredicates.isNotInRange(0, 99).test(-1));
    }

    @Test
    public void isNegative() {
        assertTrue(IntegerPredicates.isNegative().test(-1));
        assertFalse(IntegerPredicates.isNegative().test(0));
        assertFalse(IntegerPredicates.isNegative().test(1));
    }

    @Test
    public void isPositive() {
        assertTrue(IntegerPredicates.isPositive().test(1));
        assertFalse(IntegerPredicates.isPositive().test(0));
        assertFalse(IntegerPredicates.isPositive().test(-1));
    }

    @Test
    public void isEven() {
        assertTrue(IntegerPredicates.isEven().test(2));
        assertFalse(IntegerPredicates.isEven().test(1));
    }

    @Test
    public void idOdd() {
        assertTrue(IntegerPredicates.isOdd().test(1));
        assertFalse(IntegerPredicates.isOdd().test(2));
    }

}