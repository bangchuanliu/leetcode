package chapter1_2_statckandqueue.impl;

import chapter1_2_statckandqueue.IBag;
import chapter1_2_statckandqueue.PrincetonListNode;

import java.util.Iterator;

public class LinkedListBag<Item> implements IBag<Item> {
    private PrincetonListNode<Item> first;
    private int size = 0;
    
    @Override
    public void add(Item item) {
        PrincetonListNode<Item> oldFirst = first;
        first = new PrincetonListNode<>(item);
        first.next = oldFirst;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
