package datastructure.entity.tree;

import java.util.*;

public abstract class Tree {

    Node root;

    public void insert(int newValue) {
        insert(root, newValue);
    }

    abstract Node insert(Node n, int newValue);

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node n) {
        if (n != null) {
            inOrder(n.left);
            System.out.println("key:" + n.key + " len:" + n.length + " size" + n.size);
            inOrder(n.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node n) {
        if (n != null) {
            System.out.println("key:" + n.key + " len:" + n.length + " size" + n.size);
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node n) {
        if (n != null) {
            postOrder(n.left);
            postOrder(n.right);
            System.out.println("key:" + n.key + " len:" + n.length + " size" + n.size);
        }
    }

    public void BFS() {
        Queue<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).add(root);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.println(n.key);
            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
    }

    public void DFS() {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.println(n.key);
            if (n.right != null) stack.push(n.right);
            if (n.left != null) stack.push(n.left);
        }
    }

    static class Node {
        int length;
        int size;
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.length = 0;
            this.size = 1;
            this.key = key;
        }
    }
}
