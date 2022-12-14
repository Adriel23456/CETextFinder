package TextFinder.Data_Structures.Trees.AVL;

import TextFinder.Data_Structures.LinkedList.DoubleLinkedList;

/**
 * @author antonio081014
 * @time Jul 5, 2013, 9:31:32 PM
 */
public class AVLNode<T extends Comparable<T>> implements Comparable<AVLNode<T>> {

    private T data;
    private AVLNode<T> left;
    private AVLNode<T> right;
    public int level;
    private int depth;
    private DoubleLinkedList<Integer> list;

    public AVLNode(T data, int posicion) {
        this(data, null, null, posicion);
    }

    public AVLNode(T data, AVLNode<T> left, AVLNode<T> right, int posicion) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;
        this.list = new DoubleLinkedList<>();
        list.add(posicion);
        if (left == null && right == null)
            setDepth(1);
        else if (left == null)
            setDepth(right.getDepth() + 1);
        else if (right == null)
            setDepth(left.getDepth() + 1);
        else
            setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AVLNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public AVLNode<T> getRight() {
        return right;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }

    public DoubleLinkedList<Integer> getList() {return list;}

    public void setList(DoubleLinkedList<Integer> list) {this.list = list;}

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @param depth
     *            the depth to set
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public int compareTo(AVLNode<T> o) {
        return this.data.compareTo(o.data);
    }

    @Override
    public String toString() {
        return "Level " + level + ": " + data;
    }

}
