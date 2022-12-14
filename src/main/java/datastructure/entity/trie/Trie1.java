package datastructure.entity.trie;

public class Trie1 {

    private TrieNode root;

    public Trie1() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }
        p.isLeaf = true;
    }

    public boolean searchWord(String word) {
        TrieNode res = search(word);
        return (res != null && res != root && res.isLeaf);
    }

    public boolean searchPrefix(String prefix) {
        TrieNode res = search(prefix);
        return (res != null && res != root);
    }

    private TrieNode search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.children[index] == null) {
                return null;
            }
            p = p.children[index];
        }
        return p;
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isLeaf;

        public TrieNode() {
            this.children = new TrieNode[26];
            isLeaf = false;
        }
    }
}
