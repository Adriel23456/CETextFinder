package CETextFinder.EstructurasDeDatos.ArbolBinario;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree() {
        this.root = null;
    }
    public boolean isEmpty() {
        return this.root == null;
    }
    public void insert(T element,String occurence) {
        this.root = this.insert(element,occurence, this.root);
    }
    public void contains(T element) {
        this.contains(element, this.root);
    }
    private Node<T> insert(T element,String occurence, Node<T> current) {
        if (current == null) {
            return new Node<T>(element, occurence, null, null);
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
    private void contains(T element, Node<T> node) {
        if (node == null) {
            System.out.println("No hay palabras en el archivo");
        }
        else {
            int compareResult = element.compareTo(node.element);
            if (compareResult < 0) {
                this.contains(element, node.left);
            }
            else if (compareResult > 0){
                this.contains(element, node.right);
            }
            else {
                OccurenceNode current = node.getOccurencelist().getHead();
                while (current != null) {
                    System.out.println(current.getOccurence());
                    current = current.getNext();
                }
            }
        }
    }
}
