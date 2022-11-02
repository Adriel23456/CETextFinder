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

    /**
     * Metodo pricipal de llamado de lista de posiciones de un nodo en el que se buscara al nodo
     * @param element
     * @return
     */
    public DoubleLinkedList<Integer> obtainListInteger(T element) {
        DoubleLinkedList<Integer> current = contains(element, this.root);
        return current;
    }

    /**
     * Método para obtener el número de comparaciones de búsqueda de un nodo
     * @param element
     * @return
     */
    public int obtainComparaciones(T element) {
        int comparaciones = 0;
        return this.comparaciones(element, this.root, comparaciones);
    }


    /**
     * Metodo para insertar secundario pero, más importante en el árbol BST
     * @param element
     * @param occurence
     * @param current
     * @return
     */
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

    /**
     * Método secundario para obtener la lista de posiciones de una palabra
     * @param element
     * @param node
     * @return
     */
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

    /**
     * Método secundario para obtener la cantidad de comparaciones para encontrar cierta palabra
     * @param element
     * @param node
     * @param comparaciones
     * @return
     */
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
