package main.java.datastructure;

import main.java.datastructure.cache.LRUCache;

public class MainCache {
    public static void main(String[] args) {
        LRUCache cache=new LRUCache();
        cache.offer(1,45);
        cache.offer(2,4);
        cache.offer(3,6);
        cache.offer(4,56);
        cache.print();
        cache.offer(5,78);
        cache.offer(6,90);
        cache.offer(7,2);
        cache.print();
    }
}
