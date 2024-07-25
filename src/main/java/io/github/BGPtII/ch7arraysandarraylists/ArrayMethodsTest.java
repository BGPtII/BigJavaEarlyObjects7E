package io.github.BGPtII.ch7arraysandarraylists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayMethodsTest {

    @Test
    public void testSwapFirstAndLast() {
        ArrayMethods arrayMethods = new ArrayMethods(new int[] { 1, 2, 3, 4, 5 });
        arrayMethods.swapFirstAndLast();
        assertArrayEquals(new int[] { 5, 2, 3, 4, 1 }, arrayMethods.getValues());
    }

    @Test
    public void testShiftRight() {
        ArrayMethods arrayMethods = new ArrayMethods(new int[] { 1, 2, 3, 4, 5 });
        arrayMethods.shiftRight();
        assertArrayEquals(new int[] { 5, 1, 2, 3, 4 }, arrayMethods.getValues());
    }

    @Test
    public void testReplaceAllEvenWithZero() {
        ArrayMethods arrayMethods = new ArrayMethods(new int[] { -6, 1, 3, 24, -4 });
        arrayMethods.replaceAllEvenWithZero();
        assertArrayEquals(new int[] { 0, 1, 3, 0, 0 }, arrayMethods.getValues());
    }

    @Test
    public void testReplaceValuesWithLargerNeighbouringValue() {
        ArrayMethods arrayMethods1 = new ArrayMethods(new int[] { 1, 2 });
        arrayMethods1.replaceValuesWithLargerNeighbouringValue();
        assertArrayEquals(new int[] { 1, 2 }, arrayMethods1.getValues(), "Array length less than 3 should not change the array");

        ArrayMethods arrayMethods2 = new ArrayMethods(new int[] { 2, 2, 2 });
        arrayMethods2.replaceValuesWithLargerNeighbouringValue();
        assertArrayEquals(new int[] { 2, 2, 2 }, arrayMethods2.getValues(), "All equal elements should remain unchanged");

        ArrayMethods arrayMethods3 = new ArrayMethods(new int[] { 2, 1, 3, 1, 5 });
        arrayMethods3.replaceValuesWithLargerNeighbouringValue();
        assertArrayEquals(new int[] { 2, 3, 1, 5, 5 }, arrayMethods3.getValues(), "Replace all values (asides from 1st and last index)");

        ArrayMethods arrayMethods4 = new ArrayMethods(new int[] { 3, 3, 2, 4, 4 });
        arrayMethods4.replaceValuesWithLargerNeighbouringValue();
        assertArrayEquals(new int[] { 3, 3, 4, 4, 4 }, arrayMethods4.getValues(), "Replace middle element");

        ArrayMethods arrayMethods5 = new ArrayMethods(new int[] { -1, -3, -2, -4, -1 });
        arrayMethods5.replaceValuesWithLargerNeighbouringValue();
        assertArrayEquals(new int[] { -1, -1, -3, -1, -1 }, arrayMethods5.getValues(), "Replace values with negative elements");

        ArrayMethods arrayMethods7 = new ArrayMethods(new int[] { -1, 2, -3, 4, -5 });
        arrayMethods7.replaceValuesWithLargerNeighbouringValue();
        assertArrayEquals(new int[] { -1, -1, 4, -3, -5 }, arrayMethods7.getValues(), "Replace all values with mixed positive and negative elements");
    }

    @Test
    public void testRemoveMiddle() {
        ArrayMethods arrayMethods1 = new ArrayMethods(new int[] { 1, 2 });
        arrayMethods1.removeMiddle();
        assertArrayEquals(new int[] { 1, 2 }, arrayMethods1.getValues(), "Array length less than 3 should not change the array");

        ArrayMethods arrayMethods2 = new ArrayMethods(new int[] { 1, 2, 3 });
        arrayMethods2.removeMiddle();
        assertArrayEquals(new int[] { 1, 3 }, arrayMethods2.getValues(), "Remove the 2nd/middle index");

        ArrayMethods arrayMethods3 = new ArrayMethods(new int[] { 1, 2, 3, 4 });
        arrayMethods3.removeMiddle();
        assertArrayEquals(new int[] { 1, 4 }, arrayMethods3.getValues(), "Remove the 2nd & 3rd (middle) indexes");
    }

    @Test
    public void testMoveEvenValuesToFront() {
        ArrayMethods arrayMethods1 = new ArrayMethods(new int[] { 1, 2, 3, 4, 5, 6, 7, -8, 9, 10 });
        arrayMethods1.moveEvenValuesToFront();
        assertArrayEquals(new int[] { 2, 4, 6, -8, 10, 1, 3, 5, 7, 9 }, arrayMethods1.getValues());

        ArrayMethods arrayMethods2 = new ArrayMethods(new int[] { 1, 3, 5, 6, 8, -8 , 10 });
        arrayMethods2.moveEvenValuesToFront();
        assertArrayEquals(new int[] { 6, 8, -8, 10, 1, 3, 5 }, arrayMethods2.getValues());

        ArrayMethods arrayMethods3 = new ArrayMethods(new int[] { 1, 3, 5, 7, 7, 9, 2 });
        arrayMethods3.moveEvenValuesToFront();
        assertArrayEquals(new int[] { 2, 1, 3, 5, 7, 7, 9 }, arrayMethods3.getValues());
    }

    @Test
    public void testIsSortedInIncreasingOrder() {
        ArrayMethods arrayMethods1 = new ArrayMethods(new int[] { 1, 2, 3, 4, 5, 6, 7, -8, 9, 10 });
        assertFalse(arrayMethods1.isSortedInIncreasingOrder());

        ArrayMethods arrayMethods2 = new ArrayMethods(new int[] { -1, 0, 4, 6, 10 });
        assertTrue(arrayMethods2.isSortedInIncreasingOrder());
    }

    @Test
    public void testContainsTwoSameAdjacentValues() {
        ArrayMethods arrayMethods1 = new ArrayMethods(new int[] { 1, 2, 3, 4, 6, 6, 7, -8, 6, 6 });
        assertTrue(arrayMethods1.containsTwoSameAdjacentValues());

        ArrayMethods arrayMethods2 = new ArrayMethods(new int[] { -1, 0, 4, 4, 4 });
        assertFalse(arrayMethods2.containsTwoSameAdjacentValues());

        ArrayMethods arrayMethods3 = new ArrayMethods(new int[] { -1, 0, 4, -4, -4 });
        assertTrue(arrayMethods3.containsTwoSameAdjacentValues());
    }

    @Test
    public void testContainsDuplicateValues() {
        ArrayMethods arrayMethods1 = new ArrayMethods(new int[] { 1, 2, 3, 4, -6, 6, 7, -8, 5, 6 });
        assertTrue(arrayMethods1.containsDuplicateValues());

        ArrayMethods arrayMethods2 = new ArrayMethods(new int[] { 1, 2, 3, 4, 5, 6, 7, -8, 10, -6 });
        assertFalse(arrayMethods2.containsDuplicateValues());
    }
}
