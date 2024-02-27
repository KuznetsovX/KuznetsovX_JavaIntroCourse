package com.kuznetsov.homework07;

public interface ISet {

    int getValue();

    int getLength();

    boolean contains(int toCheck);

    ISet add(int toAdd);

    ISet remove(int toRemove);

    ISet removeAll();

    ISet or(ISet set);//ISet || set - Biggest

    ISet xor(ISet set);//ISet ^^ set - Medium

    ISet and(ISet set);//ISet && set - Smallest

}
