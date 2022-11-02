package TextFinder;

import TextFinder.User_Interface.Primary.Controller_Primary;
import TextFinder.User_Interface.Primary.Model_Primary;
import TextFinder.User_Interface.Primary.View_Primary;
import TextFinder.User_Interface.Show.Controller_Show;
import TextFinder.User_Interface.Show.Model_Show;
import TextFinder.User_Interface.Show.View_Show;
import TextFinder.User_Interface.Tabbedpane.Controller_Tabbedpane;
import TextFinder.User_Interface.Tabbedpane.Model_Tabbedpane;
import TextFinder.User_Interface.Tabbedpane.View_Tabbedpane;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Application {
    public static JFrame window;
    public static Controller_Primary controller_primary;
    public static Controller_Show controller_show;
    public static Controller_Tabbedpane controller_main;

    public static void main(String[] args) throws IOException, LineUnavailableException{
        /**
         * Se establece la ventana principal
         */
        window = new JFrame();
        window.setSize(850,600);
        window.setLocation(500,140);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Text Finder - Adriel Chaves - Jose Vindas");

        /**
         * Se establece el desarrollo de la ventana principal
         */
        Model_Primary model_primary = new Model_Primary();
        View_Primary view_primary = new View_Primary();
        controller_primary = new Controller_Primary(view_primary, model_primary);

        /**
         * Se establece el desarrollo de la ventana show
         */
        Model_Show model_show = new Model_Show();
        View_Show view_show = new View_Show();
        controller_show = new Controller_Show(view_show, model_show);

        /**
         * Se establece el desarrollo de la ventana Tabbed-pane
         */
        Model_Tabbedpane mainModel  = new Model_Tabbedpane();
        View_Tabbedpane mainView = new View_Tabbedpane();
        controller_main = new Controller_Tabbedpane(mainView, mainModel);

        /**
         * Se le añaden las 2 ventanas principales al Tabbed-pane
         */
        mainView.getTabbedPane().add("Main Window", view_primary.getPanel());
        mainView.getTabbedPane().add("Show Window",view_show.getPanel());

        /**
         * Se establece la visibilidad de la ventana y se inicia la aplicación
         */
        window.setVisible(true);
        controller_main.show();
    }
}
