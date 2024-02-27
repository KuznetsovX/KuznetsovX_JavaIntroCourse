package com.kuznetsov.homework06;

import com.kuznetsov.homework05.IString;
import com.kuznetsov.homework05.MutableString;

public class BufferedString extends MutableString {

    char[] arrChars;
    int length;
    int capacity;

    public BufferedString(char[] arrChars) {
        super(arrChars);
        capacity = 16;
        capacity = Integer.max(arrChars.length, capacity);
        this.arrChars = new char[capacity];
        System.arraycopy(arrChars, 0, this.arrChars, 0, arrChars.length);
        this.length = arrChars.length;
    }

    public BufferedString(int capacity) {
        super(capacity);
        this.arrChars = new char[capacity];
        this.capacity = capacity;
        this.length = 0;
    }

    private static int formulaOfGrowth(int oldCapacity) {
        return oldCapacity + oldCapacity / 2;//увеличение в полтора раза
    }

    @Override
    public IString concat(char charVar) {
        if (length == capacity) {
            capacity = formulaOfGrowth(capacity);
            char[] newArrChars = new char[capacity];
            System.arraycopy(arrChars, 0, newArrChars, 0, arrChars.length);
            arrChars = newArrChars;
        }
        arrChars[length] = charVar;
        length++;
        return this;
    }

    @Override
    public IString concat(String stringVar) {
        char[] newArrChars = stringVar.toCharArray();
        for (char newArrChar : newArrChars) {
            concat(newArrChar);
        }
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(arrChars, 0, length);
    }
}//Первое задание ✔
