package com.company.map;

public interface Map<K, V> {
    V put (K key, V value);
    V get(K key);
    boolean delete(K key);
    int size();
}
