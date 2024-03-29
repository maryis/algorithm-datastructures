package datastructure.entity.trie;

import java.util.Map;

public class Trie2 {

    private TrieNode root;

    public void insert(String w){
        insert(w,root);
    }

    private void insert(String w, TrieNode node) {
        for(int i=0;i<w.length();i++){
            node= node.getChildren().computeIfAbsent(w.charAt(i),(k) -> new TrieNode());
        }
        node.setLeaf(true);
    }

    public boolean contains(String w){
        return contains(w,root);
    }

    private boolean contains(String w, TrieNode node) {
        for(int i=0;i<w.length();i++){
            if(!node.getChildren().containsKey(w.charAt(i)))
                return false;
            node= node.getChildren().get(w.charAt(i));
        }
        return node.isLeaf();
    }

    static class TrieNode{
        Map<Character,TrieNode> children;
        boolean isLeaf;

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(Map<Character, TrieNode> children) {
            this.children = children;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean leaf) {
            isLeaf = leaf;
        }
    }
}
