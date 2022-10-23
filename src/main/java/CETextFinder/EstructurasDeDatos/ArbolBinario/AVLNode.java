package CETextFinder.EstructurasDeDatos.ArbolBinario;

public class AVLNode<T extends Comparable<T>> {
    T element;
    OccurenceList list;
    AVLNode left;
    AVLNode right;
    int height;
        public AVLNode(T element,String occurence, AVLNode left, AVLNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
            this.list = new OccurenceList();
            list.addOccurence(occurence);
        }
    public OccurenceList getOccurencelist(){
        return list;
    }
}
