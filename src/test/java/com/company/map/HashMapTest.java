package com.company.map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {
    HashMap<Integer, String> map = new HashMap<>();

    @BeforeEach
    public void setUp() {
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
    }

    @AfterEach
    public void tearDown() {
        map.clear();
    }

    @Test
    void putTest() {
        map.put(4, "4");
        assertEquals("4", map.get(4));
    }


    @Test
    void putWithExistingKeyTest() {
        map.put(2, "22");
        assertEquals("22", map.get(2));
    }


    @Test
    void getWithExistingTest() {
        assertEquals("1", map.get(1));
    }

    @Test
    void getWithUnExistingTest() {
        assertNull(map.get(100));
    }

    @Test
    void deleteWithExistingKeyTest() {
        assertTrue(map.delete(1));
        assertEquals(2, map.size());
    }

    @Test
    void deleteWithUnExistingKeyTest() {
        assertFalse(map.delete(100));
        assertEquals(3, map.size());
    }

}