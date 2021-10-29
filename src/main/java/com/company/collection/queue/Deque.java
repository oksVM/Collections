package com.company.collection.queue;

public interface Deque<E> {
    boolean addFirst(E e);
    boolean addLast(E e);
    E readFirst();
    E readLast();
    boolean deleteFirst();
    boolean deleteLast();
}
