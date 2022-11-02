package TextFinder.User_Interface.Show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;

public class Controller_Show {
    View_Show view;
    Model_Show model;
    public Controller_Show(View_Show view, Model_Show model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void openFile(String link){
        File file = new File(link);
        Desktop desktop = Desktop.getDesktop();
        try {
            Robot robot = new Robot();
            robot.mouseMove(950,550);
            desktop.open(file);
            robot.delay(2000);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.mouseWheel(5);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (AWTException ex) {
            throw new RuntimeException(ex);
        }
    }
    public View_Show getView() {return view;}
    public void setView(View_Show view) {this.view = view;}
    public Model_Show getModel() {return model;}
    public void setModel(Model_Show model) {this.model = model;}
}
