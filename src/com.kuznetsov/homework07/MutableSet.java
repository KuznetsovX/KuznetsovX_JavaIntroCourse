package com.kuznetsov.homework07;

import java.util.Arrays;

public class MutableSet implements ISet {

    int value;
    int length;

    public MutableSet() {
        value = 0;
        length = 0;
    }

    public MutableSet(int value) {
        this.value = value;
        this.length = Integer.bitCount(value);
    }

    public MutableSet(int[] arr) {
        char[] newSet = new char[32];
        Arrays.fill(newSet, '0');
        for (int i : arr) {
            newSet[31 - i] = '1';
        }
        value = Integer.parseInt(String.valueOf(newSet), 2);
        length = Integer.bitCount(value);
    }

    private static String toBinaryString(int numb) {
        return String.format("%32s", Integer.toBinaryString(numb)).replace(' ', '0');
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean contains(int toCheck) {
        return (value & (1 << toCheck)) != 0;
    }

    @Override
    public ISet add(int toAdd) {
        if (!contains(toAdd) && toAdd < 32) {
            value = value ^ (1 << toAdd);
            length = Integer.bitCount(value);
        }
        return this;
    }

    @Override
    public ISet remove(int toRemove) {
        if (contains(toRemove) && toRemove < 32) {
            value = value ^ (1 << toRemove);
            length = Integer.bitCount(value);
        }
        return this;
    }

    @Override
    public ISet removeAll() {
        value = 0;
        length = 0;
        return this;
    }

    @Override
    public ISet and(ISet set) {
        value = value & set.getValue();
        length = Integer.bitCount(value);
        return this;
    }

    @Override
    public ISet or(ISet set) {
        value = value | set.getValue();
        length = Integer.bitCount(value);
        return this;
    }

    @Override
    public ISet xor(ISet set) {
        value = value ^ set.getValue();
        length = Integer.bitCount(value);
        return this;
    }

    @Override
    public String toString() {
        return toBinaryString(value);
    }
}
