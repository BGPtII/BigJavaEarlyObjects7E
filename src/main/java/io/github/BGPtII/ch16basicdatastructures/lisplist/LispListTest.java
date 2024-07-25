package bigjavaearlyobjectsexercisesprojects.chaptersixteen.programmingprojects.lisplist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LispListTest {

    private LispList lispList1 = new NonEmptyList("A", new NonEmptyList("B", new NonEmptyList("C", new EmptyList())));
    private LispList lispList2 = LispList.NIL.cons("D").cons("E").cons("F").cons("G");

    @Test
    public void testLispListConstruction() {
        assertEquals("A B C", lispList1.toString());
        assertEquals("D E F G", lispList2.toString());
    }

    @Test
    public void testLength() {
        assertEquals(3, lispList1.length());
        assertEquals(4, lispList2.length());
    }

    @Test
    public void testMerge() {
        LispList lispList1MergedWithEmpty = lispList1.merge(LispList.NIL);
        assertEquals("A B C", lispList1MergedWithEmpty.toString());
        assertEquals(3, lispList1MergedWithEmpty.length());
        LispList emptyMergedWithLispList2 = LispList.NIL.merge(lispList2);
        assertEquals("D E F G", emptyMergedWithLispList2.toString());
        assertEquals(4, emptyMergedWithLispList2.length());
        LispList lispList1And2Merged = lispList1.merge(lispList2);
        assertEquals("A D B E C F G", lispList1And2Merged.toString());
        assertEquals(7, lispList1And2Merged.length());
    }

    @Test
    public void testContains() {
        assertTrue(lispList1.contains("B"));
        assertFalse(lispList1.contains("D"));
        assertTrue(lispList2.contains("G"));
        assertFalse(lispList2.contains("A"));
    }

}
