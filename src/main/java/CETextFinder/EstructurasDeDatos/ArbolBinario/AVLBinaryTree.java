package CETextFinder.EstructurasDeDatos.ArbolBinario;

public class AVLBinaryTree<T extends Comparable<T>> {
    private int ALLOWED_IMBALANCE = 1;
    private AVLNode<T> root;
    private int height(AVLNode t) {
        return t == null ? -1 : t.height;
    }
    public void insert(T element,String occurence) {
        this.root = this.insert(element, occurence, this.root);
    }
    private AVLNode<T> insert(T element,String occurence, AVLNode<T> current) {
        if (current == null) {
            return new AVLNode<T>(element, occurence, null, null);
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
            return balance(current);
        }
    }


    private AVLNode balance(AVLNode t) {
        if (t == null)
            return t;
        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right))
                t = rotateWithLeftChild(t);
            else
                t = doubleWithLeftChild(t);
        } else {
            if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE){
                if (height(t.right.right) >= height(t.right.left))
                    t = rotateWithRightChild(t);
                else
                    t = doubleWithRightChild(t);
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }
    private AVLNode rotateWithLeftChild(AVLNode k2) {
        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }
    private AVLNode doubleWithLeftChild(AVLNode k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
    private AVLNode rotateWithRightChild(AVLNode k2) {
        AVLNode k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }
    private AVLNode doubleWithRightChild(AVLNode k3) {
        k3.right = rotateWithRightChild(k3.right);
        return rotateWithRightChild(k3);
    }
    public void contains(T element) {
        this.contains(element, this.root);
    }
    private void contains(T element, AVLNode<T> node) {
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
