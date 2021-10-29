package com.company.collection.list.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList<Integer> list = new LinkedList<>();

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
    void addFirstTest() {
        list.addFirst(10);
        assertEquals(10, list.readFirst());
    }

    @Test
    void addLastTest() {
        list.addLast(10);
        assertEquals(10, list.readLast());
    }

    @Test
    void readFirstTest() {
        assertEquals(1, list.readFirst());
    }

    @Test
    void readLastTest() {
        assertEquals(3, list.readLast());
    }

    @Test
    void deleteFirstTest() {
        list.deleteFirst();
        assertEquals(2, list.readFirst());
    }

    @Test
    void deleteLastTest() {
        list.deleteLast();
        assertEquals(2, list.readLast());
    }


    @Test
    void readSuccessTest() {
        assertEquals(2, list.read(1));
    }

    @Test
    void readExceptionTest() {
        assertThrows(IndexOutOfBoundsException.class, ()->list.read(10));
    }

    @Test
    void deleteSuccessTest() {
        assertTrue(list.delete(1));
        assertEquals(2, list.size());
    }

    @Test
    void deleteExceptionTest() {
        assertFalse(list.delete(10));
        assertEquals(3, list.size());
    }

    @Test
    void clearTest() {
        list.clear();
        assertEquals(0, list.size());
    }

}