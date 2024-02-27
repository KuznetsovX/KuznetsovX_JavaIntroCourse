package com.kuznetsov.homework07;

import java.util.Arrays;

public class ImmutableSet implements ISet {

    int value;
    int length;

    public ImmutableSet() {
        value = 0;
        length = 0;
    }

    public ImmutableSet(int value) {
        this.value = value;
        this.length = Integer.bitCount(value);
    }

    public ImmutableSet(int[] arr) {
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
        ImmutableSet clone = new ImmutableSet(this.value);
        if (!contains(toAdd) && toAdd < 32) {
            clone.value = clone.value | (1 << toAdd);
            clone.length = Integer.bitCount(clone.value);
        }
        return clone;
    }

    @Override
    public ISet remove(int toRemove) {
        ImmutableSet clone = new ImmutableSet(this.value);
        if (contains(toRemove) && toRemove < 32) {
            clone.value = clone.value ^ (1 << toRemove);
            clone.length = Integer.bitCount(clone.value);
        }
        return clone;
    }

    @Override
    public ISet removeAll() {
        return new ImmutableSet();
    }

    @Override
    public ISet or(ISet set) {
        ImmutableSet clone = new ImmutableSet(this.value);
        clone.value = clone.value | set.getValue();
        clone.length = Integer.bitCount(clone.value);
        return clone;
    }

    @Override
    public ISet xor(ISet set) {
        ImmutableSet clone = new ImmutableSet(this.value);
        clone.value = clone.value ^ set.getValue();
        clone.length = Integer.bitCount(clone.value);
        return clone;
    }

    @Override
    public ISet and(ISet set) {
        ImmutableSet clone = new ImmutableSet(this.value);
        clone.value = clone.value & set.getValue();
        clone.length = Integer.bitCount(clone.value);
        return clone;
    }

    @Override
    public String toString() {
        return toBinaryString(value);
    }
}//Второе задание ✔
