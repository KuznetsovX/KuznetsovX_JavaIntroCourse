package com.kuznetsov.homework05;

public class MutableString implements IString {

    public char[] arrChars;
    public int length;

    public MutableString(char[] arrChars) {
        this.arrChars = arrChars.clone();
        this.length = arrChars.length;
    }

    public MutableString(int length) {
        this.length = length;
        this.arrChars = new char[length];
    }

    @Override
    public char getChar(int ind) {
        return arrChars[ind];
    }

    @Override
    public IString setChar(int ind, char newChar) {
        arrChars[ind] = newChar;
        return this;
    }

    @Override
    public IString reverse() {
        reverse(0, arrChars.length - 1);
        return this;
    }

    @Override
    public IString reverse(int from, int upTo) {
        for (int i = from, j = upTo; i < j; i++, j--) {
            swap(i, j);
        }
        return this;
    }

    @Override
    public IString swap(int firstInd, int secondInd) {
        char temp = arrChars[firstInd];
        arrChars[firstInd] = arrChars[secondInd];
        arrChars[secondInd] = temp;
        return this;
    }

    @Override
    public IString replaceCharOnlyFirst(char toReplace, char newChar) {
        for (int i = 0; i < arrChars.length; i++) {
            if (arrChars[i] == toReplace) {
                arrChars[i] = newChar;
                break;
            }
        }
        return this;
    }

    @Override
    public IString replaceCharAll(char toReplace, char newChar) {
        for (int i = 0; i < arrChars.length; i++) {
            if (arrChars[i] == toReplace) {
                arrChars[i] = newChar;
            }
        }
        return this;
    }

    @Override
    public IString concat(char charVar) {
        char[] newArrChars = new char[length + 1];
        if (length >= 0) System.arraycopy(arrChars, 0, newArrChars, 0, length);
        newArrChars[length] = charVar;
        arrChars = newArrChars;
        length++;
        return this;
    }

    @Override
    public IString concat(String stringVar) {
        char[] newArrChars = stringVar.toCharArray();
        for (int i = 0; i < newArrChars.length; i++) {
            concat(newArrChars[i]);
        }
        return this;
    }

    @Override
    public IString subString(int from, int upTo) {
        String subString = "";
        for (int i = from; i < upTo; i++) {
            subString += arrChars[i];
        }
        length = subString.toCharArray().length;
        arrChars = subString.toCharArray();
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(arrChars);
    }
}//Второе задание ✔