package CETextFinder.InterfazGrafica.Tabbedpane;

import java.util.Observable;

public class Model_Tabbedpane extends Observable {
    @Override
    public void addObserver(java.util.Observer o){
        super.addObserver(o);
        commit();
    }
    public Model_Tabbedpane(){
    }
    public void commit() {
        setChanged();
        notifyObservers(null);
    }
}
