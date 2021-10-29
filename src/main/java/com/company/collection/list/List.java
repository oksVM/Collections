package com.company.collection.list;

public interface List<E> extends Iterable<E>{

    boolean add(E e);
    E read(int index);
    boolean delete (Object o);
    int size();
    void clear();
}
