package datastructure.entity;

public class HashTable {
    int INITIAL_SIZE = 10;

    public void put(String key, String value) {
        int hash = getHash(key);
        if(entries[hash]!=null) {
            Entry temp = entries[hash];
            while(temp.next!=null)
                temp = temp.next;
            temp.next = new Entry(key, value);
        }
        else {
            entries[hash] = new Entry(key, value);
        }
    }

    private int getHash(String key) {
        return key.hashCode()% INITIAL_SIZE;
    }

    public String get(String key) {
        int hash = getHash(key);
        if(entries[hash]!=null) {
            Entry temp = entries[hash];
            while(!temp.key.equals(key) && temp.next!=null)
                temp = temp.next;
            if(temp.key.equals(key))
                return temp.value;
        }
        return null;
    }

    Entry[] entries = new Entry[INITIAL_SIZE];
    public static class Entry {
        String key;
        String value;
        Entry next;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
