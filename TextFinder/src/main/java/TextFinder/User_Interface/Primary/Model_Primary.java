package TextFinder.User_Interface.Primary;
import TextFinder.Data_Structures.LinkedList.DoubleLinkedList;
import TextFinder.Logic.CETextFinder;
import TextFinder.Logic.Document;

import java.util.Observer;

public class Model_Primary extends java.util.Observable {
    DoubleLinkedList<Document> Lista;
    public DoubleLinkedList<Document> getLista() {return Lista;}
    public void setLista(DoubleLinkedList<Document> lista) {Lista = lista;}
    private Document Selected_document = new Document();

    public void setSelected_document(Document selected_document) {
        Selected_document = selected_document;
    }

    public Document getSelected_document() {
        return Selected_document;
    }

    public Model_Primary(){
        this.setLista(new DoubleLinkedList<Document>());
    }
    /**
     * Método que relaciona el modelo con la view
     * @param o   an observer to be added.
     */
    @Override
    public void addObserver(Observer o){
        super.addObserver(o);
        commit();
    }
    /**
     * Método que realiza los cambios a la view
     */
    public void commit() {
        setChanged();
        notifyObservers(null);
    }
}
