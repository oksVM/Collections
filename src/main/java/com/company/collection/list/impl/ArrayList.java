package com.company.collection.list.impl;

import com.company.collection.list.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private E[] array;
    private int counter = 0;

    public ArrayList() {
        array =(E[]) new Object[10];
    }

    @Override
    public boolean add(E e) {
        if (array.length==counter){
            array = Arrays.copyOf(array, array.length*2);
        }
        array[counter++] = e;
        return true;
    }

    @Override
    public E read(int index){
        if (index < 0 || index >= counter)
            throw new IndexOutOfBoundsException();

        return array[index];
    }

    @Override
    public boolean delete(Object o) {
        for (int i=0; i<counter; i++){
            if(array[i].equals(o)){
                E[] newArray =(E[]) new Object[array.length];
                System.arraycopy(array, 0, newArray, 0, i);
                System.arraycopy(array, i+1, newArray, i, array.length-1-i);
                array = newArray;
                counter--;
                return true;
            }
        }
        return false;
    }

    public void clear(){
        for (E e: array){
            e = null;
        }
        counter = 0;
    }


    public E update (int index, E e){
        if (index < 0 || index >= counter)
            throw new IndexOutOfBoundsException();

        array[index] = e;
        return e;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public String toString() {
        E[] arrayToPrint =(E[]) new Object[counter];
        System.arraycopy(array, 0, arrayToPrint, 0, counter);
        return Arrays.toString(arrayToPrint);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index <counter;
            }

            @Override
            public E next() {
                return array[index++];
            }
        };
    }
}
