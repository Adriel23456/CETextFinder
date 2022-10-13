package CETextFinder;

public class Node<T extends Comparable<T>> {
    T element;
    OccurenceList list;
    Node<T> left;
    Node<T> right;
    public Node(T element,String occurence, Node<T> left, Node<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.list = new OccurenceList();
        list.addOccurence(occurence);
    }
    public OccurenceList getOccurencelist(){
        return list;
    }
}
