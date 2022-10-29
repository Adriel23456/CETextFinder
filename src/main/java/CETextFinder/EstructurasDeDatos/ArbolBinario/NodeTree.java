package CETextFinder.EstructurasDeDatos.ArbolBinario;

public class NodeTree<T extends Comparable<T>> {
    T element;
    OccurenceList list;
    NodeTree<T> left;
    NodeTree<T> right;
    public NodeTree(T element,String occurence, NodeTree<T> left, NodeTree<T> right) {
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
