package com.company.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashMap<K, V> implements Map<K, V>{
    private int size = 0;
    private double loadFactor = 0.75;
   private  Entry<K, V> [] table = new Entry [16];


  private int index(K key){
    int index = key.hashCode()%table.length;
    return index;
  }
    @Override
    public V put(K key, V value) {
      checkLoadingLevel();
      int index = index(key);
      if(table[index]==null){
          table[index]=new Entry<>(key, value);
          size++;
      } else {
          Entry<K, V> previous = null;
          Entry<K, V> e = table[index];
          while (e!=null) {
              if (e.getKey().equals(key)) {
                  e.setValue(value);
                  return value;
              }
              previous = e;
              e = e.getNext();
          }

          e = new Entry<>(key, value);
          previous.setNext(e);
          size++;
      }
        return value;
    }

    private void checkLoadingLevel() {
      if(size+1>=table.length*loadFactor){
          table = Arrays.copyOf(table, table.length*2);
      }
    }

    @Override
    public V get(K key) {
      int index = index(key);
      if(table[index]==null) return null;
      Entry<K, V> e = table[index];
      while (e!=null){
          if(table[index].getKey().equals(key)) {
              return table[index].getValue();
          } else {
              e = e.getNext();
          }

      }
        return null;
    }

    @Override
    public boolean delete(K key) {
        int index = index(key);
        if(table[index]==null) return false;
        Entry<K, V> e = table[index];
        while (e!=null){
            if(table[index].getKey().equals(key)) {
                if (e.getNext()==null){
                    table[index]=null;
                } else {
                    e.setKey(e.getNext().getKey());
                    e.setValue(e.getNext().getValue());
                    e.setNext(e.getNext().getNext());
                }
                size--;
                return true;
            } else {
                e = e.getNext();
            }

        }
      return false;
    }

    @Override
    public int size() {
        return size;
    }

    public Set<Entry<K, V>> getEntrySet(){
      Set<Entry<K, V>> set = new HashSet<>();
        Entry<K, V> [] arr = Arrays.stream(table).filter(e->e!=null).toArray(Entry[]::new);
        int index = 0;
        for (Entry e: arr){
            while (e!=null){
                set.add(e);
                e = e.getNext();
            }
        }
        return set;
    }

    @Override
    public String toString() {
        return getEntrySet().toString();
    }

    public void clear() {
      for (Entry  e: table){
          e = null;
      }
      size = 0;
    }

    public static class Entry<K,V>{
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + key + " = " + value + ']';
        }
    }
}
