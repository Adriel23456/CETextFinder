package CETextFinder.EstructurasDeDatos.ArbolBinario;

public class OccurenceList {
        private OccurenceNode head;

        public OccurenceList() {
            this.head = null;
        }

        public OccurenceNode getHead() {
            return head;
        }

        public void addOccurence(String occurence) {
            OccurenceNode Node = new OccurenceNode(occurence);
            Node.setNext(this.head);
            this.head = Node;
        }

}
