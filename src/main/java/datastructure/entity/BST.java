package  datastructure.entity;

public class BST extends Tree {//Binary Search Tree

    @Override
    Node insert(Node n, int newValue) {

        if (n == null)
            return new Node(newValue);

        if(n.key==newValue)
            return n;

        if (newValue < n.key) {
            n.size++;
            n.left = insert(n.left, newValue);
        } else if (newValue > n.key) {
            n.size++;
            n.right = insert(n.right, newValue);
        }
        int leftLen = 0;
        int rightLen = 0;
        if (n.left != null)
            leftLen = n.left.length;
        if (n.right != null)
            rightLen = n.right.length;

        n.length = max(rightLen, leftLen) + 1;

        return n;
    }

    private int max(int x, int y) {
        if (x > y)
            return x;
        else
            return y;
    }
///////////////

    public void selfBalancedInsert(int key) {
        root = selfBalancedInsert(root, key);
    }

    private Node selfBalancedInsert(Node n, int key) {
        if (n == null)
            return new Node(key);

        if (key < n.key)
            n.left = selfBalancedInsert(n.left, key);

        else if (key > n.key)
            n.right = selfBalancedInsert(n.right, key);
        else//duplicate
            return n;

        int b = getfBalance(n);

        // If this node becomes unbalanced, then there
        // are 4 cases
        // Left Left Case
        if (balance > 1 && key < n.left.key)
            return rightRotate(n);

        // Right Right Case
        if (balance < -1 && key > n.right.key)
            return leftRotate(n);

        // Left Right Case
        if (balance > 1 && key > n.left.key) {
            n.left = leftRotate(n.left);
            return rightRotate(n);
        }

        // Right Left Case
        if (balance < -1 && key < n.right.key) {
            n.right = rightRotate(n.right);
            return leftRotate(n);
        }

        return n;
    }

    private int getfBalance(Node n) {
        if (n == null)
            return 0;
        return n.left.length - n.right.length;
    }

    private Node rightRotate(Node n) {
        Node l = n.left;
        Node lr = l.right;

        n.left = lr;
        l.right = n;

        n.length = max(n.left.length, n.right.length);
        l.length = max(l.left.length, l.right.length);

        return n;

    }

    private Node leftRotate(Node n) {

        Node r = n.right;
        Node rl = r.left;

        n.right = rl;
        r.left = n;

        n.length = max(n.left.length, n.right.length);
        r.length = max(r.left.length, r.right.length);

        return n;

    }
    //////////////////////////



}
