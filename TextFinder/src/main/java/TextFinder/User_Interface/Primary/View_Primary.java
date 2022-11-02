package TextFinder.User_Interface.Primary;

import TextFinder.Application;
import TextFinder.Data_Structures.LinkedList.DoubleLinkedList;
import TextFinder.Logic.CETextFinder;
import TextFinder.Logic.Document;
import TextFinder.Logic.Service;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Boolean.FALSE;

public class View_Primary implements Observer {
    private Controller_Primary controller;
    private Model_Primary model;
    private JPanel panel;
    private JTable Documents;
    private JButton addButton;
    private JButton deleteButton;
    private JButton loadButton;
    private JTextField searchField;
    private JButton nameButton;
    private JButton wordsFoundButton;
    private JButton dateButton;
    private JButton updateButton;
    private JButton searchWordButton;
    private JButton searchPhraseButton;
    public static boolean[] documentSelected = {FALSE};
    int row = 0;

    public View_Primary(){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setTrees();
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
                FileFilter chosenfilter = new FileNameExtensionFilter("CETextFinder Files","txt","docx","pdf");
                for (FileFilter filter : fileChooser.getChoosableFileFilters()){
                    if (filter != chosenfilter){
                        fileChooser.removeChoosableFileFilter(filter);
                    }
                }
                fileChooser.setFileFilter(chosenfilter);
                int response = fileChooser.showOpenDialog(null); //Select file to open
                if (response == JFileChooser.APPROVE_OPTION){
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    try {
                        controller.documentAdd(file.getPath());
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getSelected_document().getName().equals("")){
                    JOptionPane.showMessageDialog(null,"Favor Seleccionar un archivo");
                }
                else{
                    controller.setTrees();
                    Controller_Primary.documentDelete(model.getSelected_document());
                    JOptionPane.showMessageDialog(null,"Se elimino correctamente el archivo");
                }
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getLista().getNumberOfElements() == 0){
                }
                else{
                    controller.documentsLoad();
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoubleLinkedList<Document> lista = model.getLista();
                DoubleLinkedList<String> links = new DoubleLinkedList<>();
                for (int max = lista.getNumberOfElements() - 1; max>-1; max--){
                    try {
                        links.add(lista.getElement(max).getLink());
                        Controller_Primary.documentUpdate(lista.getElement(max).getLink());
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                for (int max = links.getNumberOfElements() - 1; max>-1; max--){
                    try {
                        Controller_Primary.documentAdd2(links.getElement(max));
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                controller.getModel().setSelected_document(new Document());
                Application.controller_show.getModel().setCurrent_document(new Document());
                controller.getModel().commit();
                Application.controller_show.getModel().commit();
                controller.setTrees();
            }
        });
        nameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getLista().getNumberOfElements() == 0){
                }
                else {
                    DoubleLinkedList<Document> lista = model.getLista();
                    DoubleLinkedList<String> links = new DoubleLinkedList<>();
                    for (int max = lista.getNumberOfElements() - 1; max>-1; max--){
                        try {
                            links.add(lista.getElement(max).getLink());
                            Controller_Primary.documentUpdate(lista.getElement(max).getLink());
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                    DoubleLinkedList<String> trueLinks = Controller_Primary.nameSort(links);

                    for (int y = 0; y < trueLinks.getNumberOfElements(); y++){
                        try {
                            Controller_Primary.documentAdd2(trueLinks.getElement(y));
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    controller.getModel().setSelected_document(new Document());
                    Application.controller_show.getModel().setCurrent_document(new Document());
                    controller.getModel().commit();
                    Application.controller_show.getModel().commit();
                    controller.setTrees();
                }
            }
        });
        wordsFoundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getLista().getNumberOfElements() == 0){
                }
                else {
                    DoubleLinkedList<Document> lista = model.getLista();
                    DoubleLinkedList<String> links = new DoubleLinkedList<>();
                    DoubleLinkedList<String> texts = new DoubleLinkedList<>();
                    for (int max = lista.getNumberOfElements() - 1; max>-1; max--){
                        try {
                            links.add(lista.getElement(max).getLink());
                            texts.add(lista.getElement(max).getText1());
                            Controller_Primary.documentUpdate(lista.getElement(max).getLink());
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                    DoubleLinkedList<String> trueLinks = Controller_Primary.wordsSort(links, texts);

                    for (int y = 0; y < trueLinks.getNumberOfElements(); y++){
                        try {
                            Controller_Primary.documentAdd2(trueLinks.getElement(y));
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    controller.getModel().setSelected_document(new Document());
                    Application.controller_show.getModel().setCurrent_document(new Document());
                    controller.getModel().commit();
                    Application.controller_show.getModel().commit();
                    controller.setTrees();
                }
            }
        });
        dateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getLista().getNumberOfElements() == 0){
                }
                else {
                    DoubleLinkedList<Document> lista = model.getLista();
                    DoubleLinkedList<String> links = new DoubleLinkedList<>();
                    DoubleLinkedList<String> dates = new DoubleLinkedList<>();
                    for (int max = lista.getNumberOfElements() - 1; max>-1; max--){
                        try {
                            links.add(lista.getElement(max).getLink());
                            dates.add(lista.getElement(max).getDate());
                            Controller_Primary.documentUpdate(lista.getElement(max).getLink());
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                    DoubleLinkedList<String> trueLinks = Controller_Primary.dateSort(links, dates);

                    for (int y = 0; y < trueLinks.getNumberOfElements(); y++){
                        try {
                            Controller_Primary.documentAdd2(trueLinks.getElement(y));
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    controller.getModel().setSelected_document(new Document());
                    Application.controller_show.getModel().setCurrent_document(new Document());
                    controller.getModel().commit();
                    Application.controller_show.getModel().commit();
                    controller.setTrees();
                }
            }
        });
        searchWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CETextFinder.getAVL_Trees() == null | CETextFinder.getBST_Trees() == null){
                } else if (CETextFinder.getAVL_Trees().getNumberOfElements() == 0 | CETextFinder.getBST_Trees().getNumberOfElements() == 0) {
                } else{
                    String searchfield = getSearchField().getText();
                    controller.searchWord(searchfield);
                }
            }
        });
        searchPhraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CETextFinder.getAVL_Trees() == null | CETextFinder.getBST_Trees() == null){
                } else if (CETextFinder.getAVL_Trees().getNumberOfElements() == 0 | CETextFinder.getBST_Trees().getNumberOfElements() == 0) {
                } else{
                    String searchfield = getSearchField().getText();
                    if (searchfield.split("[ \\n(/)\"\t\\t\n,?.!]+").length != 0){
                        controller.searchPhrase(searchfield);
                    }
                    else {
                    }
                }
            }
        });
        Documents.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                row = getDocuments().getSelectedRow();
                model.setSelected_document(take(row));
                Application.controller_show.getModel().setCurrent_document(take(row));
                Application.controller_show.getModel().commit();
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        int[] cols = {Table_Model.NOMBRE,Table_Model.TYPE,Table_Model.CANTIDADDEPALABRAS,Table_Model.FECHA};
        Documents.setModel(new TextFinder.User_Interface.Primary.Table_Model(model.getLista(), cols));
        Documents.setRowHeight(25);
        this.panel.revalidate();
    }

    public void setController(Controller_Primary controller) {this.controller = controller;}
    public void setModel(Model_Primary model) {
        this.model = model;
        model.addObserver(this);
    }

    public JPanel getPanel() {
        return panel;
    }
    public JTable getDocuments() {
        return Documents;
    }
    public JButton getAddButton() {
        return addButton;
    }
    public JButton getDeleteButton() {
        return deleteButton;
    }
    public JButton getLoadButton() {
        return loadButton;
    }
    public JTextField getSearchField() {
        return searchField;
    }
    public JButton getNameButton() {return nameButton;}
    public JButton getWordsFoundButton() {return wordsFoundButton;}
    public JButton getDateButton() {return dateButton;}
    public JButton getUpdateButton() {return updateButton;}
    public JButton getSearchWordButton() {return searchWordButton;}
    public JButton getSearchPhraseButton() {return searchPhraseButton;}


    public Document take(int row){
        String code = model.getLista().getElement(row).getName();
        String code2 = model.getLista().getElement(row).getType();
        Document e = null;
        try{
            e = Service.instance().documentGet(code, code2);
        }catch (Exception ex){}
        return e;
    }
}
