package datastructure.entity.tree;

public class BST extends Tree {

    @Override
    Node insert(Node n, int newValue) {
        if (n == null)
            return new Node(newValue);

        if (n.key == newValue)
            return n;

        if (newValue < n.key) {
            n.size++;
            n.left = insert(n.left, newValue);
        } else if (newValue > n.key) {
            n.size++;
            n.right = insert(n.right, newValue);
        }
        int leftLen = n.left == null ? 0 : n.left.length;
        int rightLen = n.right == null ? 0 : n.right.length;
        n.length = Math.max(rightLen, leftLen) + 1;

        return n;
    }
}
