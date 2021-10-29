package com.company.collection.list;

import java.util.Iterator;

public interface ListIterator<E> extends Iterator<E> {
    public boolean hasNext();
    public E next();
    public boolean hasPrevious();
    public E previous();
}
