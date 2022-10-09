package CETextFinder;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree() {
        this.root = null;
    }
    public boolean isEmpty() {
        return this.root == null;
    }
    public boolean contains(T element) {
        return this.contains(element, this.root);
    }
    public void insert(T element) {
        this.root = this.insert(element, this.root);
    }
    private Node<T> insert(T element, Node<T> current) {
        if (current == null)
            return new Node<T>(element, null, null);

        int compareResult = element.compareTo(current.element);
        if (compareResult < 0)
            current.left = this.insert(element, current.left);
        else if (compareResult > 0)
            current.right = this.insert(element, current.right);
        return current;
    }
    private boolean contains(T element, Node<T> node) {
        if (node == null) {
            return false;
        } else {
            int compareResult = element.compareTo(node.element);
            if (compareResult < 0)
                return contains(element, node.left);
            else if (compareResult > 0)
                return contains(element, node.right);
            else
                return true;
        }
    }
    public Node<T> getRoot(){
        return this.root;
    }
}
