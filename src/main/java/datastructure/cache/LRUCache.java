package datastructure.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
    static class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    int count;

    public LRUCache() {
        map = new HashMap<>();
        head = new Node(0, 0);//dummy
        tail = new Node(0, 0);//dummy
        //then we don't need to check null for middle nodes
        head.prev = tail;
        tail.next = head;
        capacity = 5;
        count = 0;
    }

    public void print() {
        Node print = tail;
        while (print != null) {
            System.out.println(print.key + " : " + print.val);
            print = print.next;
        }
    }

    public int getData(int key) {
        if (map.get(key) == null)
            return -1;
        Node n = map.get(key);
        remove(n);
        offer(n);
        return n.val;
    }

    public void offer(int key, int value) {
        Node node = new Node(key, value);
        offer(node);
        map.put(key, node);
    }

    private void offer(Node n) {
        if (count == capacity) {
            removeLRU();
        }
        Node beforeHead = head.prev;
        beforeHead.next = n;
        n.prev = beforeHead;
        n.next = head;
        count++;
    }

    private void removeLRU() {
        Node toBeDeleted = tail.next;
        map.remove(toBeDeleted.key);
        toBeDeleted.next.prev = tail;
        tail.next = toBeDeleted.next;
        count--;
    }

    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        map.remove(n.key);
        count--;
    }

}

