package com.kuznetsov.homework10;

public interface IStringSet {
    int len();

    boolean isEmpty();

    boolean contains(String val);

    boolean add(String val);

    boolean remove(String val);
}
