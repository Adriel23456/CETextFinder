package TextFinder.User_Interface.Primary;

import TextFinder.Application;
import TextFinder.Data_Structures.LinkedList.DoubleLinkedList;
import TextFinder.Logic.CETextFinder;
import TextFinder.Logic.Document;
import TextFinder.Logic.Service;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Controller_Primary {
    View_Primary view;
    static Model_Primary model;

    public Controller_Primary(View_Primary view, Model_Primary model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void update(String filtro){
        DoubleLinkedList<Document> rows = Service.instance().documentSearch(filtro);
        model.setLista(rows);
        model.commit();
    }
    public static void documentDelete(Document document){
        try{
            Service.instance().deleteDocument(document);
            Application.controller_primary.getModel().commit();
            Application.controller_show.getModel().commit();
        }catch (Exception ex){}
    }

    public static void documentAdd(String file) throws FileNotFoundException {
        Service.instance().addDocument(file);
        Application.controller_primary.getModel().commit();
    }

    public static void documentAdd2(String file) throws FileNotFoundException {
        Service.instance().updateDocument2(file);
        Application.controller_primary.getModel().commit();
    }

    public static void documentUpdate(String file) throws FileNotFoundException {
        Service.instance().updateDocument(file);
        Application.controller_primary.getModel().setLista(TextFinder.Logic.CETextFinder.getDocuments());
    }

    public static DoubleLinkedList<String> nameSort(DoubleLinkedList<String> links){
        return Service.instance().nameSort(links);
    }

    public static DoubleLinkedList<String> wordsSort(DoubleLinkedList<String> links,DoubleLinkedList<String> texts){
        return Service.instance().wordsSort(links, texts);
    }

    public static DoubleLinkedList<String> dateSort(DoubleLinkedList<String> links,DoubleLinkedList<String> dates){
        return Service.instance().dateSort(links, dates);
    }

    public static void documentsLoad(){
        Service.instance().loadDocuments();
    }

    public static void setTrees(){
        Service.instance().setTrees();
    }

    public static void searchWord(String searchField){
        Service.instance().searchWords(searchField);
    }

    public static void searchPhrase(){
        String hola = "Hola";
        Service.instance().searchPhrase(hola);
    }

    public View_Primary getView() {return view;}
    public void setView(View_Primary view) {this.view = view;}
    public Model_Primary getModel() {return model;}
    public void setModel(Model_Primary model) {this.model = model;}
}
