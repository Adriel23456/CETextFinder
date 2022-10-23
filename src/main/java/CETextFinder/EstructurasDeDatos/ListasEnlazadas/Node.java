package CETextFinder.EstructurasDeDatos.ListasEnlazadas;

/**
 * Se va a crear una clase nodo para guardar las posiciones de los datos en la memoria RAM
 * @param <T> La clase nodo recibe un elemento T, para que pueda recibir cualquier tipo de información, esto incluye objetos
 * @author Adriel
 */
public class Node<T>{
     private T data;
     private Node<T> next;
     private Node<T> previous;

    /**
     * Se especifica el constructor de esta clase
     * @param next Se especifica la posición del siguiente Node
     * @param previous Se especifica la posición del anterior Node
     * @param data Se especifica la información del actual Node
     */
    public Node(Node<T> next, Node<T> previous, T data){
        this.next = next;
        this.previous = previous;
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public Node<T> getPrevious() {
        return this.previous;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}