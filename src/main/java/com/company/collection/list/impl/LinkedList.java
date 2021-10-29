package com.company.collection.list.impl;

import com.company.collection.queue.Deque;
import com.company.collection.list.List;
import com.company.collection.list.ListIterator;

import java.util.Arrays;

public class LinkedList<E> implements List<E>, Deque<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public boolean add(E e) {
        return addLast(e);
    }

    @Override
    public boolean addFirst(E e) {
        if (head == null) {
            this.head = new Node(e);
            this.tail = head;
        } else {

            Node<E> next = new Node(e, head);
            head.setPrevious(next);
            head = next;
        }
        size++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if (head == null) {
            this.head = new Node(e);
            this.tail = head;
        } else {
            Node<E> next = new Node(tail, e);
            tail.setNext(next);
            tail = next;
        }
        size++;
        return true;
    }

    @Override
    public E readFirst() {
        return head.current;
    }

    @Override
    public E readLast() {
        return tail.current;
    }

    @Override
    public boolean deleteFirst() {
        head = head.getNext();
        head.setPrevious(null);
        size--;
        return true;
    }

    @Override
    public boolean deleteLast() {
        tail = tail.getPrevious();
        tail.setNext(null);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Node<E> current = head;
        Node<E> next = current;
        while (next!=null){
            next = next.getNext();
            current = null;
            size--;
        }
    }

    @Override
    public E read(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            return readFirst();
        }

        if (index == size - 1) {
            return readLast();
        }

        int currentIndex = 0;
        Node<E> temp = head;

        while (temp != null) {
            if (currentIndex == index) {
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        return null;

    }

    public boolean delete(int index) {
        if (index < 0 || index >= size)
            return false;
        int currentIndex = 0;
        Node<E> temp = head;

        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        while (temp != null) {
            if (currentIndex == index) {
                Node<E> deleted = temp;
                temp.getPrevious().setNext(deleted.getNext());
                temp.getNext().setPrevious(deleted.getPrevious());

                size--;
                return true;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    public String toString() {
        E[] result = (E[]) new Object[size];

        int index = 0;
        Node<E> temp = head;

        for (int i = 0; i < size; i++) {
            result[index++] = temp.getValue();
            temp = temp.getNext();
        }

        return Arrays.toString(result);
    }

    @Override
    public ListIterator<E> iterator() {
        return new ListIterator<E>() {
            int index = 0;
            Node<E> nodeFromHead = head;
            Node<E> nodeFromTail = tail;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                E e = nodeFromHead.getValue();
                nodeFromHead = nodeFromHead.getNext();
                index++;
                return e;
            }

            @Override
            public boolean hasPrevious() {
                return index < size;
            }

            @Override
            public E previous() {
                E e = nodeFromTail.getValue();
                nodeFromTail = nodeFromTail.getPrevious();
                index++;
                return e;
            }
        };
    }

    private static class Node<E> {
        private Node<E> previous;
        private E current;
        private Node<E> next;


        public Node(E e) {
            this.next = null;
            this.previous = null;
            this.current = e;
        }

        public Node(Node<E> previous, E e) {
            this.next = null;
            this.previous = previous;
            this.current = e;
        }

        public Node(E e, Node<E> next) {
            this.previous = null;
            this.next = next;
            this.current = e;
        }

        public E getValue() {
            return current;
        }

        public void setValue(E e) {
            this.current = e;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrevious() {return previous;}

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return "Node{" +
                    ", current=" + current +
                    '}';
        }
    }
}
