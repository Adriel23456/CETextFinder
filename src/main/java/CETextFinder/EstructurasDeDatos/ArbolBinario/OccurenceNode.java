package CETextFinder.EstructurasDeDatos.ArbolBinario;

public class OccurenceNode {
    private String occurence;
    private OccurenceNode next;

    public OccurenceNode(String occurence) {
        this.next = null;
        this.occurence = occurence;
    }

    public void setNext(OccurenceNode next){
        this.next = next;
    }
    public String getOccurence(){
        return occurence;
    }
    public OccurenceNode getNext(){
        return next;
    }
}
