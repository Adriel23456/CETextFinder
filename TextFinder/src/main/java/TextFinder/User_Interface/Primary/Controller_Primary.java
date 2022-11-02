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

    /**
     * Constructor del Controller
     * @param view
     * @param model
     */
    public Controller_Primary(View_Primary view, Model_Primary model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    /**
     * Método que aplica Client-Server puesto que se desarrollara en otra sección de código
     * Método que elimina un documento
     * @param document
     */
    public static void documentDelete(Document document){
        try{
            Service.instance().deleteDocument(document);
            Application.controller_primary.getModel().commit();
            Application.controller_show.getModel().commit();
        }catch (Exception ex){}
    }

    /**
     * Método que aplica Client-Server puesto que se desarrollara en otra sección de código
     * Método que añade un documento
     * @param file
     * @throws FileNotFoundException
     */
    public static void documentAdd(String file) throws FileNotFoundException {
        Service.instance().addDocument(file);
        Application.controller_primary.getModel().commit();
    }

    /**
     * Método que aplica Client-Server puesto que se desarrollara en otra sección de código
     * Método que añade otro tipo de documento para otra circunstancia
     * @param file
     * @throws FileNotFoundException
     */
    public static void documentAdd2(String file) throws FileNotFoundException {
        Service.instance().updateDocument2(file);
        Application.controller_primary.getModel().commit();
    }

    /**
     * Método que aplica Client-Server puesto que se desarrollara en otra sección de código
     * Método que actualiza un documento, lo elimina de forma silenciosa
     * @param file
     * @throws FileNotFoundException
     */
    public static void documentUpdate(String file) throws FileNotFoundException {
        Service.instance().updateDocument(file);
        Application.controller_primary.getModel().setLista(TextFinder.Logic.CETextFinder.getDocuments());
    }

    /**
     * Método que aplica Client-Server puesto que se desarrollara en otra sección de código
     * Método para reorganizar los nombres
     * @param links
     * @return
     */
    public static DoubleLinkedList<String> nameSort(DoubleLinkedList<String> links){
        return Service.instance().nameSort(links);
    }

    /**
     * Método que aplica Client-Server puesto que se desarrollara en otra sección de código
     * Metodo para reorganizar la cantidad de palabras
     * @param links
     * @param texts
     * @return
     */
    public static DoubleLinkedList<String> wordsSort(DoubleLinkedList<String> links,DoubleLinkedList<String> texts){
        return Service.instance().wordsSort(links, texts);
    }

    /**
     * Método que aplica Client-Server puesto que se desarrollara en otra sección de código
     * Método para reorganizar por fechas
     * @param links
     * @param dates
     * @return
     */
    public static DoubleLinkedList<String> dateSort(DoubleLinkedList<String> links,DoubleLinkedList<String> dates){
        return Service.instance().dateSort(links, dates);
    }

    /**
     * Método que aplica Client-Server puesto que se desarrollara en otra sección de código
     * Método para cargar un documento seleccionado
     */
    public static void documentsLoad(){
        Service.instance().loadDocuments();
    }

    /**
     * Método que aplica Client-Server puesto que se desarrollara en otra sección de código
     * Metodo para borrar los árboles actuales de la aplicación
     */
    public static void setTrees(){
        Service.instance().setTrees();
    }

    /**
     * Método que aplica Client-Server puesto que se desarrollara en otra sección de código
     * Método para buscar por palabras en un documento
     * @param searchField
     */
    public static void searchWord(String searchField){
        Service.instance().searchWords(searchField);
        JOptionPane.showMessageDialog(null,"Se termino el proceso de búsqueda para todos los documentos");
    }

    /**
     * Método que aplica Client-Server puesto que se desarrollara en otra sección de código
     * Método para buscar por frases en un documento
     * @param text
     */
    public static void searchPhrase(String text){
        Service.instance().searchPhrase(text);
        JOptionPane.showMessageDialog(null,"Se termino el proceso de búsqueda para todos los documentos");
    }

    public View_Primary getView() {return view;}
    public void setView(View_Primary view) {this.view = view;}
    public Model_Primary getModel() {return model;}
    public void setModel(Model_Primary model) {this.model = model;}
}
