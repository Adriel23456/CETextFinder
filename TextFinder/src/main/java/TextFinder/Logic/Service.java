package TextFinder.Logic;


import TextFinder.Application;
import TextFinder.Data_Structures.LinkedList.DoubleLinkedList;
import TextFinder.Data_Structures.Trees.AVL.AVL;
import TextFinder.Data_Structures.Trees.BST.BST;
import TextFinder.Data_Structures.Trees.BST.BSTNode;
import TextFinder.Logic.SortAlgorithms.BubbleSort;
import TextFinder.Logic.SortAlgorithms.QuickSort;
import TextFinder.Logic.SortAlgorithms.RadixSort;
import TextFinder.User_Interface.Primary.View_Primary;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Service {
    private static Service instance;
    static CETextFinder data = CETextFinder.instance();

    public static Service instance(){
        if (instance == null ){
            instance = new Service();
        }
        return instance;
    }

    public DoubleLinkedList<Document> documentSearch(String filtro){
        DoubleLinkedList<Document> Lista = new DoubleLinkedList<>();
        for (int i = 0; i< Application.controller_primary.getModel().getLista().getNumberOfElements(); i++){
            if(filtro.equals(Application.controller_primary.getModel().getLista().getElement(i).getName())){
                Lista.add(Application.controller_primary.getModel().getLista().getElement(i));
            } else if (filtro.equals("")) {
                Lista.add(Application.controller_primary.getModel().getLista().getElement(i));
            }
        }
        return Lista;
    }

    public void deleteDocument(Document document){
        for (int i = 0; i< data.getDocuments().getNumberOfElements(); i++){
            if(data.getDocuments().getElement(i).getName().equals(document.getName())){
                if(data.getDocuments().getElement(i).getType().equals(document.getType())){
                    data.getDocuments().remove(i);
                    Application.controller_show.getModel().setCurrent_document(new Document());
                    Application.controller_primary.getModel().setSelected_document(new Document());
                    Application.controller_primary.getModel().setLista(data.getDocuments());
                }
            }
        }
    }

    public static Document documentGet(String name, String type){
        for (int i = 0; i<data.getDocuments().getNumberOfElements(); i++){
            if(data.getDocuments().getElement(i).getName().equals(name)){
                if(data.getDocuments().getElement(i).getType().equals(type)){
                    return data.getDocuments().getElement(i);
                }
            }
        }
        return null;
    }

    public static void updateDocument(String link){
        for (int i = 0; i<data.getDocuments().getNumberOfElements(); i++){
            if(data.getDocuments().getElement(i).getLink().equals(link)){
                if (Application.controller_show.getModel().getCurrent_document().getLink().equals(link)){
                    View_Primary.documentSelected[0] = FALSE;
                    Application.controller_show.getModel().setCurrent_document(new Document());
                    Application.controller_show.getModel().commit();
                }
                data.getDocuments().remove(i);
            }
        }
    }

    public void updateDocument2(String link){
        int a = link.lastIndexOf("\\");
        int b = link.lastIndexOf(".");
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String text = "";
        String name = link.substring(a+1,b);
        String type = link.substring(b+1);
        String text2 = "";
        DoubleLinkedList<Integer> posiciones = new DoubleLinkedList<>();
        int BST_Search = 0;
        int AVL_Search = 0;
        Path path = Paths.get(link);
        try{
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            String date = sd.format(attributes.lastModifiedTime().toMillis());
            if (type.equals("txt")){
                BufferedReader reader = new BufferedReader(new FileReader(link));
                String linea;
                while ((linea = reader.readLine()) != null){
                    text = text+linea+"\n";
                }
                String text1 = text;
                Document newdocument = new Document(name, type, date, link, text1, text2, posiciones, BST_Search, AVL_Search);
                addDocumentRedundant2(newdocument);
            } else if (type.equals("docx")) {
                FileInputStream fs = new FileInputStream(link);
                XWPFDocument docx = new XWPFDocument(fs);
                List<XWPFParagraph> paragraphList = docx.getParagraphs();
                for (XWPFParagraph paragraph: paragraphList){
                    text = text+paragraph.getText()+"\n";
                }
                String text1 = text;
                Document newdocument = new Document(name, type, date, link, text1, text2, posiciones, BST_Search, AVL_Search);
                addDocumentRedundant2(newdocument);
            }
            else{
                PDDocument pdf = PDDocument.load(new File(link));
                PDFTextStripper pdftext = new PDFTextStripper();
                text = pdftext.getText(pdf);
                String text1 = text;
                Document newdocument = new Document(name, type, date, link, text1, text2, posiciones, BST_Search, AVL_Search);
                pdf.close();
                addDocumentRedundant2(newdocument);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void addDocument(String link) {
        int a = link.lastIndexOf("\\");
        int b = link.lastIndexOf(".");
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String text = "";
        String name = link.substring(a+1,b);
        String type = link.substring(b+1);
        String text2 = "";
        DoubleLinkedList<Integer> posiciones = new DoubleLinkedList<>();
        int BST_Search = 0;
        int AVL_Search = 0;
        Path path = Paths.get(link);
        try{
            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            String date = sd.format(attributes.lastModifiedTime().toMillis());
            if (type.equals("txt")){
                BufferedReader reader = new BufferedReader(new FileReader(link));
                String linea;
                while ((linea = reader.readLine()) != null){
                    text = text+linea+"\n";
                }
                String text1 = text;
                Document newdocument = new Document(name, type, date, link, text1, text2, posiciones, BST_Search, AVL_Search);
                addDocumentRedundant(newdocument);
            } else if (type.equals("docx")) {
                FileInputStream fs = new FileInputStream(link);
                XWPFDocument docx = new XWPFDocument(fs);
                List<XWPFParagraph> paragraphList = docx.getParagraphs();
                for (XWPFParagraph paragraph: paragraphList){
                    text = text+paragraph.getText()+"\n";
                }
                String text1 = text;
                Document newdocument = new Document(name, type, date, link, text1, text2, posiciones, BST_Search, AVL_Search);
                addDocumentRedundant(newdocument);
            }
            else{
                PDDocument pdf = PDDocument.load(new File(link));
                PDFTextStripper pdftext = new PDFTextStripper();
                text = pdftext.getText(pdf);
                String text1 = text;
                Document newdocument = new Document(name, type, date, link, text1, text2, posiciones, BST_Search, AVL_Search);
                pdf.close();
                addDocumentRedundant(newdocument);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addDocumentRedundant(Document newdocument){
        if (revisarDocument(newdocument) == TRUE){
            data.getDocuments().add(newdocument);
            Application.controller_primary.getModel().setLista(data.getDocuments());
            JOptionPane.showMessageDialog(null,"Se agrego correctamente el archivo");
        }
        else{
            JOptionPane.showMessageDialog(null,"No se puede repetir el archivo");
        }
    }

    public void addDocumentRedundant2(Document newdocument){
        if (revisarDocument(newdocument) == TRUE){
            data.getDocuments().add(newdocument);
            Application.controller_primary.getModel().setLista(data.getDocuments());
        }
        else{
        }
    }

    public boolean revisarDocument(Document newdocument){
        for (int i = 0; i<data.getDocuments().getNumberOfElements(); i++){
            if (data.getDocuments().getElement(i).getName().equals(newdocument.getName())){
                if (data.getDocuments().getElement(i).getType().equals(newdocument.getType())){
                    return FALSE;
                }
            }
        }
        return TRUE;
    }

    public void loadDocuments(){
        data.setAVL_Trees(new DoubleLinkedList<>());
        data.setBST_Trees(new DoubleLinkedList<>());
        for (int i = 0; i<data.getDocuments().getNumberOfElements(); i++){
            String text = data.getDocuments().getElement(i).getText1();
            String word[] = text.split("[ \\n(/)\"\t\\t\n,?.!]+");
            AVL<String> arbol_avl = new AVL<>();
            BST<String> arbol_bst = new BST<>();
            for(int y=0;y< word.length;y++){
                arbol_avl.insert(word[y], y);
                arbol_bst.insert(word[y], y);
            }
            data.getAVL_Trees().add(arbol_avl);
            data.getBST_Trees().add(arbol_bst);
        }
        JOptionPane.showMessageDialog(null,"Se añadieron correctamente los árboles");
    }

    public void setTrees(){
        data.setAVL_Trees(new DoubleLinkedList<>());
        data.setBST_Trees(new DoubleLinkedList<>());
    }

    public void searchWords(String frase){
        for (int i = 0; i<data.getDocuments().getNumberOfElements(); i++){
            int comparacionesBST = 0;
            int comparacionesAVL = 0;
            DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
            data.getDocuments().getElement(i).setPosiciones(new DoubleLinkedList<Integer>());
            String word[] = frase.split("[ \\n(/)\"\t\\t\n,?.!]+");
            for(int y=0;y< word.length;y++){
                list = data.getBST_Trees().getElement(i).obtainListInteger(word[y]);
                if (list.getNumberOfElements() != 0){
                    for (int f=0;f<list.getNumberOfElements(); f++){
                        int currentNumber = list.getElement(f);
                        data.getDocuments().getElement(i).getPosiciones().add(currentNumber);
                        comparacionesBST = comparacionesBST + data.getBST_Trees().getElement(i).obtainComparaciones(word[y]);
                        comparacionesAVL = comparacionesAVL + data.getAVL_Trees().getElement(i).search(word[y]);
                    }
                }
            }
            //Se terminó de repasar las palabras que se deseaban buscar...
            data.getDocuments().getElement(i).setAVL_Search(comparacionesAVL);
            data.getDocuments().getElement(i).setBST_Search(comparacionesBST);


            data.getDocuments().getElement(i).setText2(data.getDocuments().getElement(i).getText1());


            //System.out.println("Se encontraron las siguientes posiciones por archivo: "+ data.getDocuments().getElement(i).getPosiciones());
        }
        JOptionPane.showMessageDialog(null,"Se termino el proceso de búsqueda para todos los documentos");
    }

    public void searchPhrase(String frase){
        //VA A PROVOCAR QUE TODOS LOS ARCHIVOS TENGAN EN SU LISTA DE POSICIONES TODAS LAS COINCIDENCIAS ENCONTRADAS...
        searchWords(frase);
        //Se intentará que solamente permanezcan las coincidencias en donde en una posición inicial (i) hasta una posición final (j) se reproduzcan coincidencias constantes...
    }

    public static DoubleLinkedList<String> nameSort(DoubleLinkedList<String> links){
        String [] linksArray = new String [links.getNumberOfElements()];
        String [] namesArray = new String [links.getNumberOfElements()];
        for (int i = 0; i < linksArray.length; i++){
            //Se establece que el valor de tal posición del arreglo será el de tal posición de la lista
            linksArray[i] = links.getElement(i);
            //Se va a repasar este arreglo y se estarán obteniendo los nombres y metiéndolos en un nuevo arreglo
            int a = linksArray[i].lastIndexOf("\\");
            int b = linksArray[i].lastIndexOf(".");
            String name = linksArray[i].substring(a+1,b);
            namesArray[i] = name;
        }

        //Aplicar el código de QuickSort para arreglo de strings de nombres, pero, por cada swap, asegurarse que también se esté haciendo un swap en el arreglo de los links...
        QuickSort.sort(namesArray, linksArray);
        linksArray = QuickSort.getLinks();

        //Crear una lista de strings con el arreglo acomodado y retornarlo
        DoubleLinkedList<String> newlist = new DoubleLinkedList<>();
        for (int i = 0; i < linksArray.length; i++){
            newlist.add(linksArray[i]);
        }
        return newlist;
    }


    public static DoubleLinkedList<String> wordsSort(DoubleLinkedList<String> links, DoubleLinkedList<String> texts){
        String [] linksArray = new String [links.getNumberOfElements()];
        int [] numberOfWords = new int [links.getNumberOfElements()];
        for (int i = 0; i < linksArray.length; i++){
            linksArray[i] = links.getElement(i);
            //Se va a abrir el documento y extraer su texto:
            String text = texts.getElement(i);
            String word[] = text.split("[ \\n(/)\"\t\\t\n,?.!]+");
            //Se establecera la cantidad de palabras por el texto...
            int cantidad = word.length;
            //Se establece que el valor de tal posición del arreglo será el de tal posición de la lista
            numberOfWords[i] = cantidad;
        }

        //Aplicar el código de Radixsort para arreglo de int de cantidaDePalabras, pero, por cada swap, asegurarse que también se esté haciendo un swap en el arreglo de los links...
        RadixSort.radixSort(numberOfWords, linksArray);

        linksArray = RadixSort.getLinks();

        //Crear una lista de strings con el arreglo acomodado y retornarlo
        DoubleLinkedList<String> newlist = new DoubleLinkedList<>();
        for (int i = 0; i < linksArray.length; i++){
            newlist.add(linksArray[i]);
        }
        return newlist;
    }


    public static DoubleLinkedList<String> dateSort(DoubleLinkedList<String> links, DoubleLinkedList<String> dates){
        String [] linksArray = new String [links.getNumberOfElements()];
        int [] datesArray = new int [links.getNumberOfElements()];
        for (int i = 0; i < linksArray.length; i++){
            linksArray[i] = links.getElement(i);
            //Se va a abrir el documento y extraer su texto:
            String text = dates.getElement(i);
            String word[] = text.split("[ \\n(/)\"\t\\t\n,?.!]+");
            //El arreglo de word ahora tiene 3 palabras (dia, mes y año) para el primer elemento del arreglo de dates
            String date = "";
            for (int f = word.length - 1; f > -1; f--){
                date = date + word[f];
            }
            int realDate = Integer.parseInt(date);
            //Se establece que el valor de tal posición del arreglo será el de tal posición de la lista de fechas...
            datesArray[i] = realDate;
        }

        //Aplicar el código de BubbleSort para arreglo de integers de fechas, pero, por cada swap, asegurarse que también se esté haciendo un swap en el arreglo de los links...
        BubbleSort.bubbleSort(datesArray, linksArray);
        linksArray = BubbleSort.getLinks();

        //Crear una lista de strings con el arreglo acomodado y retornarlo
        DoubleLinkedList<String> newlist = new DoubleLinkedList<>();
        for (int i = 0; i < linksArray.length; i++){
            newlist.add(linksArray[i]);
        }
        return newlist;
    }
}
