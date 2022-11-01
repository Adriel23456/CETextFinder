package TextFinder.User_Interface.Show;

import TextFinder.Logic.Document;

import javax.print.Doc;
import java.util.Observer;

public class Model_Show extends java.util.Observable {
    Document current_document;
    public Document getCurrent_document() {return current_document;}
    public void setCurrent_document(Document current_document) {this.current_document = current_document;}
    public Model_Show(){
        current_document = new Document();
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
