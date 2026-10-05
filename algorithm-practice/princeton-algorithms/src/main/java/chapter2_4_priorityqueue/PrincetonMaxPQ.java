package chapter2_4_priorityqueue;

public interface PrincetonMaxPQ<Key extends Comparable<Key>> {

    void insert(Key v);

    Key max();

    Key delMax();

    boolean isEmpty();

    int size();
}
