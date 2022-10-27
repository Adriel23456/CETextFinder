package CETextFinder.EstructurasDeDatos.ArbolBinario;

public class OccurenceList {
        private OccurenceNode head;

        private int lenth ;
        public OccurenceList() {
            this.head = null;
            this.lenth = 0;
        }

        public void addOccurence(String occurence) {
            OccurenceNode Node = new OccurenceNode(occurence);
            if (this.head == null){
                Node.setNext(this.head);
            }
            else {
                OccurenceNode aux = this.head;
                Node.setNext(this.head);
                aux.setPrevious(Node);
            }
            this.head = Node;
            this.lenth++;
        }
    public OccurenceNode getHead() {
            return head;
    }
    public int getLenth() {
            return lenth;
    }
    public void setHead(OccurenceNode head){
            this.head = head;
    }
}
