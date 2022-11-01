package TextFinder.Data_Structures.LinkedList;

/**
 * Esta es la clase de lista doblemente enlazada, la cual, nos permitirá guardar las instancias de un objeto por posición en una lista.
 * @param <T>
 * @author Adriel
 */
public class DoubleLinkedList<T>{
    private Node<T> head;
    private int numberOfElements;

    /**
     * Aquí se establecen los valores predeterminados de la lista.
     */
    public DoubleLinkedList() {
        this.numberOfElements = 0;
        this.head = null;
    }

    /**
     * Este método nos permite indicar que la lista actual está vacía.
     * @return Vuelve el atributo de la clase Node a null.
     */
    public boolean isEmpty(){
        return this.head == null;
    }

    /**
     * Este método nos permite obtener la cantidad de elementos que hay en la lista actual.
     * @return Retorna un int con la cantidad de elementos.
     */
    public int getNumberOfElements() {
        return this.numberOfElements;
    }

    /**
     * Este método nos permite añadir un valor al final de la lista.
     *
     * @param data Se establece que requiere de una información "T" para añadirla a la lista actual.
     * @return
     */
    public void add(T data){
        //En el caso que la lista este vacía, generara un nuevo Nodo y lo establecerá como el primero:
        if(isEmpty()){
            this.head = new Node<T>(null, null, data);
        }
        //En el caso que la lista no este vacía, va a recorrer toda la lista hasta llegar al último elemento, y, generara el nuevo Nodo:
        else{
            Node<T> temporal = this.head;
            for(; temporal.getNext() != null; temporal = temporal.getNext());
            temporal.setNext(new Node(null, temporal, data));
        }
        this.numberOfElements++;
    }

    /**
     * Este método nos permite eliminar, utilizando la posición del elemento, un Nodo de la lista.
     * @param position Se establece la posición de la lista que se desea eliminar.
     */
    public void remove(int position){
        if (this.getNumberOfElements() > position){
            Node<T> temporal = this.head;
            for (int i = 0; i < position; i++){
                temporal = temporal.getNext();
            }
            //Aquí se indica que, si el nodo a eliminar es el primer elemento, entonces simplemente cambia el valor al siguiente Node
            if(temporal == this.head){
                this.head = temporal.getNext();
            }
            //Aquí se indica que, si el nodo a eliminar es otro elemento entonces, provoca que el nodo anterior ignore al actual y siga con el siguiente
            else{
                temporal.getPrevious().setNext(temporal.getNext());
                if (temporal.getNext() != null) {
                    temporal.getNext().setPrevious(temporal.getPrevious());
                }
            }
            this.numberOfElements--;
        }
        else{System.out.println("Index out of range");}
    }

    /**
     * Este método nos permite obtener un elemento utilizando la posición que le indiquemos al programa.
     * @param position Se establece la posición en la lista que se desea buscar.
     * @return Este método puede retornar null si la posición indicada está fuera del rango, o, retorna la información del Nodo indicado en la lista actual.
     */
    public T getElement(int position){
        if(this.numberOfElements > position){
            Node<T> temporal = this.head;
            //Aquí recorre la lista hasta que encuentre a la posición correcta y retorna la data "T" del Node
            for (int i = 0; i < position; i++){
                temporal = temporal.getNext();
            }
            return temporal.getData();
        }
        System.out.println("Index out of range");
        return null;
    }

    /**
     * Este método nos permite obtener todas las informaciones de los nodos en la lista, los representa como un "string" y, los introduce en un variable.
     * @return Este método nos retorna la información de los nodos de la lista actual, los cuales fueron guardados en la variable "s", junto con un salto de línea.
     */
    public String toString(){
        String s = "{ ";
        Node<T> node = this.head;
        if (node == null)
            return s + " }";
        while (node.getNext() != null){
            s += String.valueOf(node.getData())+" \n-> ";
            node = node.getNext();
        }
        s += String.valueOf(node.getData());
        return s + "\n}";
    }
}
