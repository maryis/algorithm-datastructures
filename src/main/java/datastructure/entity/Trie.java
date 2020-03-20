package main.java.datastructure.entity;

public class Trie {

    class TrieNode {
        TrieNode[] children;
        //char letter; no need, index shows letter , index char s= s-'a'
        boolean isLeaf;

        public TrieNode() {
            this.children = new TrieNode[26];
            isLeaf = false;
        }
    }

    private TrieNode root;
    StringBuilder str;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (p.children[index] != null) {
                p = p.children[index];
            } else {
                p.children[index] = new TrieNode();
                p = p.children[index];
            }
        }
        p.isLeaf = true;
    }

    public boolean searchWord(String word) {

        TrieNode res = search(word);
        if (res != null && res != root && res.isLeaf)
            return true;
        else
            return false;
    }

    public boolean serachPrefix(String prefix) {

        TrieNode res = search(prefix);
        if (res != null && res != root)
            return true;

        return false;
    }

    private TrieNode search(String word) {
        TrieNode p = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (p.children[index] != null) {
                p = p.children[index];
            } else {
                return null;
            }
        }
        return p;

    }

    public void dfs(){
        str=new StringBuilder();
        dfs(root);
    }
    private void dfs(TrieNode p) {
        if(p==null)
            return;

        for (int i = 0; i < 26; i++)
            if (p.children[i] != null) {
                str.append((char) (i + 'a'));  //convert index to letter
                if (p.children[i].isLeaf) {
                    System.out.println(str);
                } else {
                    dfs(p.children[i]);
                }
                str.deleteCharAt(str.length()-1);

            }



        }
    }
