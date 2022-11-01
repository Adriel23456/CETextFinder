package TextFinder.Data_Structures.Trees.BST;

import TextFinder.Data_Structures.LinkedList.DoubleLinkedList;

public class BST<T extends Comparable<T>> {

    private BSTNode<T> root;

    public BST() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(T element,int occurence) {
        this.root = this.insert(element,occurence, this.root);
    }

    public DoubleLinkedList<Integer> obtainListInteger(T element) {
        DoubleLinkedList<Integer> current = contains(element, this.root);
        return current;
    }

    public int obtainComparaciones(T element) {
        int comparaciones = 0;
        return this.comparaciones(element, this.root, comparaciones);
    }


    private BSTNode<T> insert(T element,int occurence, BSTNode<T> current) {
        if (current == null) {
            return new BSTNode<T>(element, occurence, null, null);
        }
        else{
            int compareResult = element.compareTo(current.element);
            if (compareResult < 0) {
                current.left = this.insert(element, occurence, current.left);
            }
            else if (compareResult > 0) {
                current.right = this.insert(element, occurence, current.right);
            }
            else {
                current.getList().add(occurence);
            }
            return current;
        }
    }
    private DoubleLinkedList<Integer> contains(T element, BSTNode<T> node) {
        if (node == null) {
            DoubleLinkedList<Integer> current = new DoubleLinkedList<>();
            return current;
        }
        else {
            int compareResult = element.compareTo(node.element);
            if (compareResult < 0) {
                return contains(element, node.left);
            }
            else if (compareResult > 0){
                return contains(element, node.right);
            }
            else {
                return node.getList();
            }
        }
    }

    private int comparaciones(T element, BSTNode<T> node, int comparaciones) {
        int compareResult = element.compareTo(node.element);
        if (compareResult < 0) {
            comparaciones = comparaciones + 1;
            return comparaciones(element, node.left, comparaciones);
        }
        else if (compareResult > 0){
            comparaciones = comparaciones + 1;
            return comparaciones(element, node.right, comparaciones);
        }
        else {
            comparaciones = comparaciones + 1;
            return comparaciones;
        }
    }

}
