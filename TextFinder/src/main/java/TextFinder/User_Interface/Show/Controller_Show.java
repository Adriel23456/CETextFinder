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
                System.out.println("Se abrió un documento TXT");
                desktop.open(file);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (model.current_document.getType().equals("docx")) {
            Desktop desktop = Desktop.getDesktop();
            try {
                System.out.println("Se abrió un documento DOCX");
                desktop.open(file);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else{
            Desktop desktop = Desktop.getDesktop();
            try {
                System.out.println("Se abrió un documento PDF");
                desktop.open(file);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public View_Show getView() {return view;}
    public void setView(View_Show view) {this.view = view;}
    public Model_Show getModel() {return model;}
    public void setModel(Model_Show model) {this.model = model;}
}
