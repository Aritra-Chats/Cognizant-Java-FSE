package org.cognizant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        // assertEquals
        assertEquals(5, 2 + 3);
        // assertTrue
        assertTrue(10 > 2);
        // assertFalse
        assertFalse(2 > 10);
        // assertNull
        String name = null;
        assertNull(name);
        // assertNotNull
        Object obj = new Object();
        assertNotNull(obj);
    }
}
