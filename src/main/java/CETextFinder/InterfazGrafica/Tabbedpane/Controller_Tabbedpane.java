package CETextFinder.InterfazGrafica.Tabbedpane;

import CETextFinder.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller_Tabbedpane implements ActionListener {
    Model_Tabbedpane model;
    View_Tabbedpane view;

    public Controller_Tabbedpane(View_Tabbedpane view, Model_Tabbedpane model) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.commit();
    }
    //public void show(){Application.window.setContentPane(view.getTabbedPane());}
}
