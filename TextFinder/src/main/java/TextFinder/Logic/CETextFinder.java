package TextFinder.Logic;

import TextFinder.Data_Structures.Trees.AVL.AVL;
import TextFinder.Data_Structures.LinkedList.DoubleLinkedList;
import TextFinder.Data_Structures.Trees.BST.BST;

public class CETextFinder {
    private static DoubleLinkedList<Document> documents;
    private static DoubleLinkedList<BST> BST_Trees;
    private static DoubleLinkedList<AVL> AVL_Trees;

    /**
     * Este es un atributo estático para establecer que CEMusicPlayer es una instancia.
     */
    private static CETextFinder instance;

    /**
     * Este es un método el cual agarra a la clase y, se asegura de crear una instancia de esta en caso de que no exista alguna.
     * @return Esto retorna la instancia de la clase
     */
    public static CETextFinder instance(){
        if (instance == null ){
            instance = new CETextFinder();
            documents = new DoubleLinkedList<Document>();
            BST_Trees = new DoubleLinkedList<BST>();
            AVL_Trees = new DoubleLinkedList<AVL>();
        }
        return instance;
    }

    public static DoubleLinkedList<Document> getDocuments() {return documents;}
    public static void setDocuments(DoubleLinkedList<Document> documents) {CETextFinder.documents = documents;}
    public static DoubleLinkedList<BST> getBST_Trees() {return BST_Trees;}
    public static void setBST_Trees(DoubleLinkedList<BST> BST_Trees) {CETextFinder.BST_Trees = BST_Trees;}
    public static DoubleLinkedList<AVL> getAVL_Trees() {return AVL_Trees;}
    public static void setAVL_Trees(DoubleLinkedList<AVL> AVL_Trees) {CETextFinder.AVL_Trees = AVL_Trees;}
}
