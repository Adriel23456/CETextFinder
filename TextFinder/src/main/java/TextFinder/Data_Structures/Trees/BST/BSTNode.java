package TextFinder.Data_Structures.Trees.BST;

import TextFinder.Data_Structures.LinkedList.DoubleLinkedList;

public class BSTNode<T extends Comparable<T>> {
    T element;
    DoubleLinkedList<Integer> list;
    BSTNode<T> left;
    BSTNode<T> right;
    public BSTNode(T element, int occurence, BSTNode<T> left, BSTNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.list = new DoubleLinkedList<>();
        list.add(occurence);
    }
    public DoubleLinkedList<Integer> getList() {
        return list;
    }
}
