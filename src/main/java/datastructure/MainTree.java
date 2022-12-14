package  datastructure;

import datastructure.entity.trie.Trie1;

public class MainTree {
    public static void main(String[] args) {


//        BST myTree=new BST();
//        myTree.insert(5);
//        myTree.insert(12);
//        myTree.insert(3);
//        myTree.insert(67);
//        myTree.insert(45);
//
//        System.out.println("inorder");
//        myTree.inOrder();
//
//        System.out.println("preOrder");
//        myTree.preOrder();
//
//        System.out.println("PostOrder");
//        myTree.postOrder();
//
//        System.out.println("BFS");
//        myTree.BFS();
//
//        System.out.println("DFS");
//        myTree.DFS();

        Trie1 dictionary=new Trie1();
        dictionary.insert("hello");
        dictionary.insert("salam");
        dictionary.insert("hei");

        System.out.println("does exist hello?"+dictionary.searchWord("hello"));
        System.out.println("does exist hella?"+dictionary.searchWord("hella"));
        System.out.println("does prefix exist he?"+dictionary.searchPrefix("he"));
        System.out.println("does prefix exist sal?"+dictionary.searchPrefix("sal"));
        System.out.println("does prefix exist sald?"+dictionary.searchPrefix("sald"));

        dictionary.dfs();




    }
}
