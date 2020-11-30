package Skiplist;

import java.util.concurrent.locks.ReentrantLock;

public class Node {
    int key;
    int value;
    int level;
    Node[] next;

    ReentrantLock lock;
    boolean fullyLinked;
    boolean markedForRemoval;

    public Node(int key, int value, int level, int maxLevel) {
        this.key = key;
        this.value = value;
        this.level = level;
        this.next = new Node[maxLevel];
        this.fullyLinked = true;
        this.markedForRemoval = false;
        this.lock = new ReentrantLock();//реализует интерфейс Lock.
    }

    public String toString() {
        return Integer.toString(value);
    }
}
