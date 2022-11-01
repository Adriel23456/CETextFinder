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

    @Override
    public String toString(){
        return "Document{" +
                "name = " + name + '\'' +
                "type = " + type + '\'' +
                "date = " + date + '\'' +
                "link = " + link + '\'' +
                "text1 = " + text1 + '\'' +
                "text2 = " + text2 + '\'' +
                "posiciones = " + posiciones.getNumberOfElements() + '\'' +
                "BST = " + BST_Search + '\'' +
                "AVL = " + AVL_Search + '}';
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
