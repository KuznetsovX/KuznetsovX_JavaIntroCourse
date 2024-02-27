package com.kuznetsov.homework08;

public class CharStack implements ICharStack {

    int length;//можно заменить переменной nextIndex
    char[] arr;
    int capacity = 16;

    public CharStack() {
        arr = new char[capacity];
        length = 0;
    }

    private void ensureCapacity() {
        if (length == capacity) {
            capacity += capacity / 2;
            char[] newArr = new char[capacity];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public void add(char charVar) {
        ensureCapacity();
        arr[length++] = charVar;
    }

    @Override
    public char get() {
        return arr[length - 1];
    }

    @Override
    public char remove() {
        return arr[--length];
    }
}
