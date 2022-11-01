package TextFinder.Data_Structures.Trees.AVL;

import TextFinder.Data_Structures.LinkedList.DoubleLinkedList;
import TextFinder.Data_Structures.LinkedList.Node;

import java.util.LinkedList;
import java.util.Queue;

public class AVL<T extends Comparable<T>> {
    AVLNode<T> root;

    public AVL() {
        root = null;
    }

    public T Maximum() {
        AVLNode<T> local = root;
        if (local == null)
            return null;
        while (local.getRight() != null)
            local = local.getRight();
        return local.getData();
    }

    public T Minimum() {
        AVLNode<T> local = root;
        if (local == null)
            return null;
        while (local.getLeft() != null) {
            local = local.getLeft();
        }
        return local.getData();
    }

    private int depth(AVLNode<T> node) {
        if (node == null)
            return 0;
        return node.getDepth();
    }

    public AVLNode<T> insert(T data, int number) {
        root = insert(root, data, number);
        switch (balanceNumber(root)) {
            case 1:
                root = rotateLeft(root, number);
                break;
            case -1:
                root = rotateRight(root, number);
                break;
            default:
                break;
        }
        return root;
    }

    public AVLNode<T> insert(AVLNode<T> node, T data, int number) {
        if (node == null)
            return new AVLNode<T>(data, number);
        if (node.getData().compareTo(data) > 0) {
            node = new AVLNode<T>(node.getData(), insert(node.getLeft(), data, number), node.getRight(), number);
            // node.setLeft(insert(node.getLeft(), data));
        } else if (node.getData().compareTo(data) < 0) {
            // node.setRight(insert(node.getRight(), data));
            node = new AVLNode<T>(node.getData(), node.getLeft(), insert(node.getRight(), data, number), number);
        }
        // After insert the new node, check and rebalance the current node if
        // necessary.
        switch (balanceNumber(node)) {
            case 1:
                node = rotateLeft(node, number);
                break;
            case -1:
                node = rotateRight(node, number);
                break;
            default:
                return node;
        }
        node.getList().add(number);
        return node;
    }

    private int balanceNumber(AVLNode<T> node) {
        int L = depth(node.getLeft());
        int R = depth(node.getRight());
        if (L - R >= 2)
            return -1;
        else if (L - R <= -2)
            return 1;
        return 0;
    }

    private AVLNode<T> rotateLeft(AVLNode<T> node, int number) {
        AVLNode<T> q = node;
        AVLNode<T> p = q.getRight();
        AVLNode<T> c = q.getLeft();
        AVLNode<T> a = p.getLeft();
        AVLNode<T> b = p.getRight();
        q = new AVLNode<T>(q.getData(), c, a, number);
        p = new AVLNode<T>(p.getData(), q, b, number);
        return p;
    }

    private AVLNode<T> rotateRight(AVLNode<T> node, int number) {
        AVLNode<T> q = node;
        AVLNode<T> p = q.getLeft();
        AVLNode<T> c = q.getRight();
        AVLNode<T> a = p.getLeft();
        AVLNode<T> b = p.getRight();
        q = new AVLNode<T>(q.getData(), b, c, number);
        p = new AVLNode<T>(p.getData(), a, q, number);
        return p;
    }

    public int search(T data) {
        AVLNode<T> local = root;
        int comparaciones = 0;
        while (local != null) {
            if (local.getData().compareTo(data) == 0){
                comparaciones = comparaciones + 1;
                return comparaciones;
            }
            else if (local.getData().compareTo(data) > 0){
                comparaciones = comparaciones + 1;
                local = local.getLeft();
            }
            else{
                comparaciones = comparaciones + 1;
                local = local.getRight();
            }
        }
        return comparaciones;
    }

    public String toString() {
        return root.toString();
    }

    public void PrintTree() {
        root.level = 0;
        Queue<AVLNode<T>> queue = new LinkedList<AVLNode<T>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            AVLNode<T> node = queue.poll();
            System.out.println(node);
            int level = node.level;
            AVLNode<T> left = node.getLeft();
            AVLNode<T> right = node.getRight();
            if (left != null) {
                left.level = level + 1;
                queue.add(left);
            }
            if (right != null) {
                right.level = level + 1;
                queue.add(right);
            }
        }
    }
}