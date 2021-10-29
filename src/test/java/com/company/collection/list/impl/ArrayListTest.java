package com.company.collection.list.impl;

import com.company.collection.list.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    ArrayList<Integer> list = new ArrayList<Integer>();

    @BeforeEach
    public void setUp(){
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @AfterEach
    public void tearDown(){
        list.clear();
    }

    @Test
    void addTest() {
        list.add(4);
        assertEquals(4, list.size());
    }

    @Test
    void readSuccessTest() {
        assertEquals(3, list.read(2));
    }

    @Test
    void readExceptionTest() {
        assertThrows(IndexOutOfBoundsException.class, ()->list.read(100));
    }

    @Test
    void deleteSuccessTest() {
        assertTrue(list.delete(1));
        assertEquals(2, list.size());
    }

    @Test
    void deleteUnSuccessfulTest() {
        assertFalse(list.delete(100));
        assertEquals(3, list.size());
    }

    @Test
    void updateSuccessTest() {
        list.update(0,1000);
        assertEquals(1000, list.read(0));
    }

    @Test
    void updateExceptionTest() {
        assertThrows(IndexOutOfBoundsException.class, ()->list.update(100,1000));
    }

    @Test
    void clearTest() {
        list.clear();
        assertEquals(0, list.size());
    }

}