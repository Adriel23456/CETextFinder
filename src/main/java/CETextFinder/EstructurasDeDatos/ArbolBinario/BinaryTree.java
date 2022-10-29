package CETextFinder.EstructurasDeDatos.ArbolBinario;

public class BinaryTree<T extends Comparable<T>> {
    private NodeTree<T> root;

    public BinaryTree() {
        this.root = null;
    }
    public boolean isEmpty() {
        return this.root == null;
    }
    public void insert(T element,String occurence) {
        this.root = this.insert(element,occurence, this.root);
    }
    public OccurenceNode contains(T element) {
        return contains(element, this.root);
    }
    private NodeTree<T> insert(T element,String occurence, NodeTree<T> current) {
        if (current == null) {
            return new NodeTree(element, occurence, null, null);
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
                current.getOccurencelist().addOccurence(occurence);
            }
            return current;
        }
    }
    private OccurenceNode contains(T element, NodeTree<T> node) {
        if (node == null) {
            return null;
        }
        else {
            int compareResult = element.compareTo(node.element);
            if (compareResult < 0) {
                return this.contains(element, node.left);
            } else if (compareResult > 0) {
                return this.contains(element, node.right);
            } else {
                return node.getOccurencelist().getHead();
            }
        }
    }
}


