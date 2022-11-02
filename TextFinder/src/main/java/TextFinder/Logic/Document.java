package TextFinder.Logic;

import TextFinder.Data_Structures.LinkedList.DoubleLinkedList;

public class Document {
    private String name;
    private String type;
    private String date;
    private String link;
    private String text1;
    private String text2;
    private DoubleLinkedList<Integer> posiciones;
    private int BST_Search;
    private int AVL_Search;

    /**
     * Contructor de la clase de Document para cuando se poseen variables definidas
     * @param name
     * @param type
     * @param date
     * @param link
     * @param text1
     * @param text2
     * @param posiciones
     * @param BST_Search
     * @param AVL_Search
     */
    public Document(String name, String type, String date, String link, String text1, String text2, DoubleLinkedList<Integer> posiciones, int BST_Search, int AVL_Search) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.link = link;
        this.text1 = text1;
        this.text2 = text2;
        this.posiciones = posiciones;
        this.BST_Search = BST_Search;
        this.AVL_Search = AVL_Search;
    }

    /**
     * Contructor para documentos nuevos
     */
    public Document(){
        this.name = "";
        this.type = "";
        this.date = "";
        this.link = "";
        this.text1 = "";
        this.text2 = "";
        this.posiciones = new DoubleLinkedList<>();
        this.BST_Search = 0;
        this.AVL_Search = 0;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}
    public String getLink() {return link;}
    public void setLink(String link) {this.link = link;}
    public String getText1() {return text1;}
    public void setText1(String text1) {this.text1 = text1;}
    public String getText2() {return text2;}
    public void setText2(String text2) {this.text2 = text2;}
    public DoubleLinkedList<Integer> getPosiciones() {return posiciones;}
    public void setPosiciones(DoubleLinkedList<Integer> posiciones) {this.posiciones = posiciones;}
    public int getBST_Search() {return BST_Search;}
    public void setBST_Search(int BST_Search) {this.BST_Search = BST_Search;}
    public int getAVL_Search() {return AVL_Search;}
    public void setAVL_Search(int AVL_Search) {this.AVL_Search = AVL_Search;}
}
