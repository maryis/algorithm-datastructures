package  datastructure.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    //another way to think: have a hach-func : x% capacity
    //instead of map we can use an array

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;
    int count;

    public LRUCache() {
        map=new HashMap<>();
        head=null;
        tail=null;
        capacity=5;
        count=0;
    }

    public void print(){
        Node print=tail;
        while(print!=null){
            System.out.println(print.key+" : "+print.val);
            print=print.next;
        }
    }
    public int getData(int key){
        if(map.get(key)==null)
            return -1;//cache miss
        Node n=map.get(key);
        remove(n);
        offer(n);
        return n.val;
    }

    public void offer(int key,int value){
        Node node=new Node(key,value);
        offer(node);
        map.put(key,node);
    }

    private void offer(Node n) {
        if(head==null) {
            head = n;
            head.next = head.prev = null;
            tail=n;
            count=1;
        }
        else{
            if(count==capacity){
                removeLRU();
            }
            head.next=n;
            n.prev=head;
            n.next=null;
            head=n;
            count++;
        }
    }

    private void removeLRU() {
        if(tail!=null){
            map.remove(tail.key);
            tail.next.prev=null;
            tail=tail.next;
            count--;
        }
    }

    private void remove(Node n) {
        if(n.prev!=null)
            n.prev.next=n.next;
        else {
            tail = n.next;
            tail.prev = null;
        }

        if(n.next!=null)
            n.next.prev=n.prev;
        else {
            head = n.prev;
            head.next = null;
        }
        map.remove(n.key);
        count--;
    }

}

