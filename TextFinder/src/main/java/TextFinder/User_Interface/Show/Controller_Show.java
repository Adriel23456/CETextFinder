package TextFinder.User_Interface.Show;

import javax.swing.*;
import java.awt.*;

public class Controller_Show {
    View_Show view;
    Model_Show model;
    public Controller_Show(View_Show view, Model_Show model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    public View_Show getView() {return view;}
    public void setView(View_Show view) {this.view = view;}
    public Model_Show getModel() {return model;}
    public void setModel(Model_Show model) {this.model = model;}
}
