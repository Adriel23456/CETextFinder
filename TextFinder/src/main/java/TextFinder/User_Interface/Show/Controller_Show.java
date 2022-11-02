package TextFinder.User_Interface.Show;

import TextFinder.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Controller_Show {
    View_Show view;
    Model_Show model;
    Boolean searchWords;
    public Controller_Show(View_Show view, Model_Show model) {
        this.view = view;
        this.model = model;
        this.searchWords = true;
        view.setController(this);
        view.setModel(model);
    }

    /**
     * Método que aplica Client-Server puesto que se desarrollara en otra sección de código
     * Método para abrir un archivo en una posición específica
     * @param link
     */
    public void openFile(String link){
        File file = new File(link);
        if (model.current_document.getType().equals("txt")){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(file);
                String Palabra = "";
                if (model.getCurrent_document().getPosiciones().getNumberOfElements() == 0){
                }
                else if (searchWords){
                    String text = Application.controller_primary.getView().getSearchField().getText();
                    String[] word = text.split("[ \\n(/)\"\t\\t\n,?.!]+");
                    Palabra = word[0];
                }
                else {
                    String text2 = Application.controller_primary.getView().getSearchField().getText();
                    Palabra = text2;
                }
                char[] CharPalabra = Palabra.toCharArray();
                Robot robot = new Robot();
                robot.delay(1000);
                robot.mouseMove(1000, 300);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_B);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_B);
                for (char Letra : CharPalabra) {
                    robot.keyPress(Character.toUpperCase(Letra));
                    robot.keyRelease(Character.toUpperCase(Letra));
                }
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.keyPress(KeyEvent.VK_ESCAPE);
                robot.keyRelease(KeyEvent.VK_ESCAPE);
                robot.keyPress(KeyEvent.VK_ESCAPE);
                robot.keyRelease(KeyEvent.VK_ESCAPE);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        }
        else if (model.current_document.getType().equals("docx")) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(file);
                String Palabra = "";
                if (model.getCurrent_document().getPosiciones().getNumberOfElements() == 0){
                }
                else if (searchWords){
                    String text = Application.controller_primary.getView().getSearchField().getText();
                    String[] word = text.split("[ \\n(/)\"\t\\t\n,?.!]+");
                    Palabra = word[0];
                }
                else {
                    String text2 = Application.controller_primary.getView().getSearchField().getText();
                    Palabra = text2;
                }
                char[] CharPalabra = Palabra.toCharArray();
                Robot robot = new Robot();
                robot.delay(1500);
                robot.mouseMove(1000, 300);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_B);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_B);
                for (char Letra : CharPalabra) {
                    robot.keyPress(Character.toUpperCase(Letra));
                    robot.keyRelease(Character.toUpperCase(Letra));
                }
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.keyPress(KeyEvent.VK_ESCAPE);
                robot.keyRelease(KeyEvent.VK_ESCAPE);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(file);
                String Palabra = "";
                if (model.getCurrent_document().getPosiciones().getNumberOfElements() == 0){
                }
                else if (searchWords){
                    String text = Application.controller_primary.getView().getSearchField().getText();
                    String[] word = text.split("[ \\n(/)\"\t\\t\n,?.!]+");
                    Palabra = word[0];
                }
                else {
                    String text2 = Application.controller_primary.getView().getSearchField().getText();
                    Palabra = text2;
                }
                char[] CharPalabra = Palabra.toCharArray();
                Robot robot = new Robot();
                robot.delay(2000);
                robot.mouseMove(1000, 300);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_F);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_F);
                for (char Letra : CharPalabra) {
                    robot.keyPress(Character.toUpperCase(Letra));
                    robot.keyRelease(Character.toUpperCase(Letra));
                }
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public View_Show getView() {return view;}
    public void setView(View_Show view) {this.view = view;}
    public Model_Show getModel() {return model;}
    public void setModel(Model_Show model) {this.model = model;}

    public Boolean getSearchWords() {
        return searchWords;
    }

    public void setSearchWords(Boolean searchWords) {
        this.searchWords = searchWords;
    }
}
