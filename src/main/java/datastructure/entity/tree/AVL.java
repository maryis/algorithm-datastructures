package datastructure.entity.tree;

public class AVL extends Tree {

    @Override
    Node insert(Node n, int key) {
        if (n == null) return new Node(key);
        if (n.key == key) return n;

        if (key < n.key)
            n.left = insert(n.left, key);

        else if (key > n.key)
            n.right = insert(n.right, key);

        int balance = getBalanceFactor(n);

        // Left Case
        if (balance > 1) {
            //Left Right case
            if (key > n.left.key)
                //we convert it to left left case
                n.left = leftRotate(n.left);
            //we do a right rotate on left left case
            return rightRotate(n);
        }

        // Right Case
        if (balance < -1 ) {
            //Right Left Case
            if (key > n.right.key)
                //we convert it to right right case
                n.right = rightRotate(n.right);
            //we do a left rotate on right right case
            return leftRotate(n);
        }
        return n;
    }

    private int getBalanceFactor(Node n) {
        if (n == null) return 0;
        return n.left.length - n.right.length;
    }

    private Node rightRotate(Node n) {
        Node goUp = n.left;
        n.left = goUp.right;
        goUp.right = n;

        n.length = getMaxChild(n);
        goUp.length = getMaxChild(goUp);

        return goUp;
    }

    private Node leftRotate(Node n) {
        Node goUp = n.right;
        n.right = goUp.left;
        goUp.left = n;

        n.length = getMaxChild(n);
        goUp.length = getMaxChild(goUp);

        return goUp;
    }

    private int getMaxChild(Node n) {
        return Math.max(n.left.length, n.right.length);
    }
}
