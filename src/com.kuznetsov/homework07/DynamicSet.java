package com.kuznetsov.homework07;

import java.util.Arrays;

public class DynamicSet implements ISet {

    int[] arr;
    int size;

    public DynamicSet() {
        arr = new int[0];
        size = 0;
    }

    public DynamicSet(int[] arr) {
        this();
        for (int i : arr) {
            add(i);
        }
    }

    public DynamicSet(ISet set) {
        DynamicSet dynamicSet = (DynamicSet) set;
        arr = dynamicSet.arr;
        size = dynamicSet.size;
    }

    int[] ensureCapacity(int[] arr, int index) {
        if (index > arr.length - 1) {
            arr = Arrays.copyOf(arr, index + 1);
        }
        return arr;
    }

    @Override
    public int getValue() {
        throw new RuntimeException("Doesn't work here.");
    }

    @Override
    public int getLength() {
        return size;
    }

    @Override
    public boolean contains(int toCheck) {
        int index = toCheck / 32;
        toCheck = toCheck % 32;
        if (index > arr.length - 1) {
            return false;
        }
        return (arr[index] & (1 << toCheck)) > 0;
    }

    @Override
    public ISet add(int toAdd) {
        if (!contains(toAdd)) {
            int index = toAdd / 32;
            int bit = toAdd % 32;
            arr = ensureCapacity(arr, index);
            arr[index] |= (1 << bit);
            size++;
        }
        return this;
    }

    @Override
    public ISet remove(int toRemove) {
        if (contains(toRemove)) {
            int index = toRemove / 32;
            int bit = toRemove % 32;
            arr = ensureCapacity(arr, index);
            arr[index] ^= (1 << bit);
            size--;
        }
        return this;
    }

    @Override
    public ISet removeAll() {
        arr = new int[0];
        size = 0;
        return this;
    }

    @Override
    public ISet or(ISet set) {
        DynamicSet dynamicSet = new DynamicSet(set);
        int indexMax = Math.max(arr.length, dynamicSet.arr.length) - 1;
        arr = ensureCapacity(arr, indexMax);
        dynamicSet.arr = ensureCapacity(dynamicSet.arr, indexMax);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] | dynamicSet.arr[i];
        }

        size = 0;
        for (int j : arr) {
            size += Integer.bitCount(j);
        }

        return this;
    }

    @Override
    public ISet xor(ISet set) {
        DynamicSet dynamicSet = new DynamicSet(set);
        int indexMax = Math.max(arr.length, dynamicSet.arr.length) - 1;
        arr = ensureCapacity(arr, indexMax);
        dynamicSet.arr = ensureCapacity(dynamicSet.arr, indexMax);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] ^ dynamicSet.arr[i];
        }

        size = 0;
        for (int j : arr) {
            size += Integer.bitCount(j);
        }

        return this;
    }

    @Override
    public ISet and(ISet set) {
        DynamicSet dynamicSet = new DynamicSet(set);
        int indexMax = Math.max(arr.length, dynamicSet.arr.length) - 1;
        arr = ensureCapacity(arr, indexMax);
        dynamicSet.arr = ensureCapacity(dynamicSet.arr, indexMax);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] & dynamicSet.arr[i];
        }

        size = 0;
        for (int j : arr) {
            size += Integer.bitCount(j);
        }

        return this;
    }

    @Override
    public String toString() {
        int[] newArr = new int[size];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentNumber = Integer.toBinaryString(arr[i]).length();
            for (int j = 0, k = 1; j < currentNumber; j++, k = k << 1) {
                if ((arr[i] & k) != 0) {
                    newArr[index] = 32 * i + j;
                    index++;
                }
            }
        }
        return Arrays.toString(newArr);
    }
}//Третье задание ✔
