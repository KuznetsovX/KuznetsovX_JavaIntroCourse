package com.kuznetsov.homework09;

public class Deque implements IDeque, IArray {

    int length;
    Node head;
    Node tail;

    public Deque() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        length = 0;
    }

    @Override
    public int length() {
        return length;
    }//O(1)

    @Override
    public boolean isEmpty() {
        return length == 0;
    }//O(1)

    @Override
    public void addFirst(int val) {
        Node newNode = new Node();
        newNode.val = val;

        Node firstNode = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = firstNode;
        firstNode.prev = newNode;

        length++;
    }//0(1)

    @Override
    public void addLast(int val) {
        Node newNode = new Node();
        newNode.val = val;

        Node lastNode = tail.prev;
        tail.prev = newNode;
        newNode.next = tail;
        newNode.prev = lastNode;
        lastNode.next = newNode;

        length++;
    }//O(1)

    @Override
    public int getFirst() {
        return head.next.val;
    }//O(1)

    @Override
    public int getLast() {
        return tail.prev.val;
    }//O(1)

    @Override
    public int removeFirst() {
        int ans = getFirst();

        head.next = head.next.next;
        head.next.prev = head;

        length--;
        return ans;
    }//O(1)

    @Override
    public int removeLast() {
        int ans = getLast();

        tail.prev = tail.prev.prev;
        tail.prev.next = tail;

        length--;
        return ans;
    }//O(1)

    @Override
    public void add(int val) {
        addLast(val);
    }//O(1)

    @Override
    public int get(int ind) {
        if (ind >= length) {
            return 0;
        }
        Node toGet = find(ind);
        return toGet.val;
    }//O(n)

    @Override
    public void set(int ind, int val) {
        if (ind < length) {
            Node toSet = find(ind);
            toSet.val = val;
        }
    }//O(n)

    @Override
    public void insert(int ind, int val) {
        if (ind < length) {
            Node toInsert = find(ind);

            Node newNode = new Node();
            newNode.val = toInsert.val;
            toInsert.val = val;

            Node firstNode = toInsert.next;

            toInsert.next = newNode;
            newNode.prev = toInsert;
            newNode.next = firstNode;
            firstNode.prev = newNode;

            length++;
        }
    }//O(n)

    @Override
    public void remove(int ind) {
        if (ind < length) {
            Node toRemove = find(ind);
            toRemove.prev.next = toRemove.next;
            toRemove.next.prev = toRemove.prev;

            length--;
        }

    }//O(n)

    private Node find(int ind) {
        int mid = length / 2;
        Node toFind = new Node();

        if (ind < mid) {
            for (int i = 0; i < ind + 1; i++) {
                toFind = head.next;
                head = head.next;
            }
        } else {
            for (int i = 0; i < length - ind; i++) {
                toFind = tail.prev;
                tail = tail.prev;
            }
        }
        return toFind;
    }//O(n)

    private static class Node {
        int val;
        Node prev;
        Node next;
    }


}