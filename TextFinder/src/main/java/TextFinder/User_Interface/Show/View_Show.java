package TextFinder.User_Interface.Show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class View_Show implements Observer {
    private Controller_Show controller;
    private Model_Show model;
    private JPanel panel;
    private JLabel documentName;
    private JLabel numberBST;
    private JLabel numberAVL;
    private JEditorPane documentText;
    private JButton openButton;

    public View_Show() {
        documentText.setContentType("text/html");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.current_document.getName().equals("")){
                    JOptionPane.showMessageDialog(null,"Favor Seleccionar un archivo");
                }
                else{
                    File file = new File(model.current_document.getLink());
                    if (model.current_document.getType().equals("txt")){
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            desktop.open(file);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (model.current_document.getType().equals("docx")) {
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            desktop.open(file);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    else{
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            desktop.open(file);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
    }
    @Override
    public void update(Observable o, Object arg) {
        documentName.setText(model.current_document.getName());
        numberAVL.setText(String.valueOf(model.current_document.getAVL_Search()));
        numberBST.setText(String.valueOf(model.current_document.getBST_Search()));
        documentText.setText(model.current_document.getText2());
    }
    public void setController(Controller_Show controller) {this.controller = controller;}
    public void setModel(Model_Show model) {
        this.model = model;
        model.addObserver(this);
    }
    public JPanel getPanel() {return panel;}
    public JLabel getDocumentName() {return documentName;}
    public JLabel getNumberBST() {return numberBST;}
    public JLabel getNumberAVL() {return numberAVL;}
    public JButton getOpenButton() {return openButton;}
    public JEditorPane getDocumentText() {return documentText;}
}
