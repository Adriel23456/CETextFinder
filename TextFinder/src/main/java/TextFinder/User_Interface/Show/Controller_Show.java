package TextFinder.User_Interface.Show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
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
                String text = model.current_document.getText1();
                String[] words = text.split("[ \\n(/)\"\t\\t\n,?.!]+");
                int p;
                for (p = 0; p < words.length; p++) {
                    if (p == model.getCurrent_document().getPosiciones().getElement(0)) {
                        break;
                    }
                }
                String Palabra = words[p];
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
                String text = model.current_document.getText1();
                String[] words = text.split("[ \\n(/)\"\t\\t\n,?.!]+");
                int p;
                for (p = 0; p < words.length; p++) {
                    if (p == model.getCurrent_document().getPosiciones().getElement(0)) {
                        break;
                    }
                }
                String Palabra = words[p];
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
                System.out.println("Se abrió un documento PDF");
                desktop.open(file);
                String text = model.current_document.getText1();
                String[] words = text.split("[ \\n(/)\"\t\\t\n,?.!]+");
                int p;
                for (p = 0; p < words.length; p++) {
                    if (p == model.getCurrent_document().getPosiciones().getElement(0)) {
                        break;
                    }
                }
                System.out.println(words[p]);
                String Palabra = words[p];
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
}
