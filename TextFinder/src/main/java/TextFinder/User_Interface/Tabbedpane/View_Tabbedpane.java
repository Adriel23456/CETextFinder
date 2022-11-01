package TextFinder.User_Interface.Tabbedpane;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class View_Tabbedpane implements Observer {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    Controller_Tabbedpane controller;
    Model_Tabbedpane model;

    public void setController(Controller_Tabbedpane controller){ this.controller = controller; }

    public void setModel(Model_Tabbedpane model) {
        this.model = model;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane1;
    }

    @Override
    public void update(Observable o, Object arg) {
    }
}
