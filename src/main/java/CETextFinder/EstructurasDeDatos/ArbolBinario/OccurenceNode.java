package CETextFinder.EstructurasDeDatos.ArbolBinario;

public class OccurenceNode {
    private String occurence;
    private OccurenceNode next;
    private OccurenceNode previous;

    public OccurenceNode(String occurence) {
        this.next = null;
        this.previous = null;
        this.occurence = occurence;
    }

    public void setOccurence(String occurence) {
        this.occurence = occurence;
    }
    public void setNext(OccurenceNode next){
        this.next = next;
    }
    public void setPrevious(OccurenceNode previous){
        this.previous = previous;
    }
    public String getOccurence(){
        return occurence;
    }
    public OccurenceNode getNext(){
        return next;
    }
    public OccurenceNode getPrevious(){
        return previous;
    }
}
