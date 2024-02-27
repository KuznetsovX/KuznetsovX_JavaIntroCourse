package com.kuznetsov.homework05;

public class ImmutableString implements IString {

    char[] arrChars;
    int length;

    public ImmutableString(char[] arrChars) {
        this.arrChars = arrChars.clone();
        this.length = arrChars.length;
    }

    public ImmutableString(int length) {
        this.length = length;
        this.arrChars = new char[length];
    }

    @Override
    public char getChar(int ind) {
        return arrChars[ind];
    }

    @Override
    public IString setChar(int ind, char newChar) {
        ImmutableString clone = new ImmutableString(this.arrChars);
        clone.arrChars[ind] = newChar;
        return clone;
    }

    @Override
    public IString reverse() {
        ImmutableString clone = new ImmutableString(this.arrChars);

        for (int i = 0, j = clone.length - 1; i < j; i++, j--) {
            char temp = clone.arrChars[i];
            clone.arrChars[i] = clone.arrChars[j];
            clone.arrChars[j] = temp;
        }
        return clone;
    }

    @Override
    public IString reverse(int from, int upTo) {
        ImmutableString clone = new ImmutableString(this.arrChars);

        for (int i = from, j = upTo; i < j; i++, j--) {
            char temp = clone.arrChars[i];
            clone.arrChars[i] = clone.arrChars[j];
            clone.arrChars[j] = temp;
        }
        return clone;
    }

    @Override
    public IString swap(int firstInd, int secondInd) {
        ImmutableString clone = new ImmutableString(this.arrChars);

        char temp = clone.arrChars[firstInd];
        clone.arrChars[firstInd] = clone.arrChars[secondInd];
        clone.arrChars[secondInd] = temp;
        return clone;
    }

    @Override
    public IString replaceCharOnlyFirst(char toReplace, char newChar) {
        ImmutableString clone = new ImmutableString(this.arrChars);

        for (int i = 0; i < clone.length; i++) {
            if (clone.arrChars[i] == toReplace) {
                clone.arrChars[i] = newChar;
                break;
            }
        }
        return clone;
    }

    @Override
    public IString replaceCharAll(char toReplace, char newChar) {
        ImmutableString clone = new ImmutableString(this.arrChars);

        for (int i = 0; i < clone.length; i++) {
            if (clone.arrChars[i] == toReplace) {
                clone.arrChars[i] = newChar;
            }
        }
        return clone;
    }

    @Override
    public IString concat(char charVar) {
        ImmutableString clone = new ImmutableString(this.length + 1);

        if (length >= 0) System.arraycopy(this.arrChars, 0, clone.arrChars, 0, length);
        /*for (int i = 0; i < length; i++) {
            clone.arrChars[i] = this.arrChars[i];
        }*/
        clone.arrChars[length] = charVar;
        return clone;
    }

    @Override
    public IString concat(String stringVar) {
        ImmutableString clone = new ImmutableString(this.length + stringVar.length());

        if (clone.length >= 0) System.arraycopy(this.arrChars, 0, clone.arrChars, 0, length);
        /* Second variant. Using statement "for".
        for (int i = 0; i < length; i++) {
            clone.arrChars[i] = this.arrChars[i];
        }*/
        if (clone.length - length >= 0)
            System.arraycopy(stringVar.toCharArray(), 0, clone.arrChars, length, clone.length - length);
        /* Second variant. Using statement "for".
        char[] newCharArr = stringVar.toCharArray();
        for (int i = length; i < clone.length; i++) {
            clone.arrChars[i] = newCharArr[i - length];
        }*/
        return clone;
    }

    @Override
    public IString subString(int from, int upTo) {
        ImmutableString clone = new ImmutableString(this.arrChars);

        String subString = "";
        for (int i = from; i < upTo; i++) {
            subString += clone.arrChars[i];
        }
        clone.length = subString.toCharArray().length;
        clone.arrChars = subString.toCharArray();
        return clone;
    }

    @Override
    public String toString() {
        return String.valueOf(arrChars);
    }
}//Третье задание ✔
