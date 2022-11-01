package TextFinder.User_Interface.Primary;

import TextFinder.Data_Structures.LinkedList.DoubleLinkedList;
import TextFinder.Logic.Document;

import javax.swing.table.AbstractTableModel;

public class Table_Model extends AbstractTableModel {
    DoubleLinkedList<Document> rows;
    int [] cols;

    public Table_Model(DoubleLinkedList<Document> rows, int[] cols) {
        initColNames();
        this.rows = rows;
        this.cols = cols;
    }
    public int getRowCount() {return rows.getNumberOfElements();}

    public String getColumnName(int col){
        return colNames[cols[col]];
    }

    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            default: return super.getColumnClass(col);
        }
    }

    public int getColumnCount() {return cols.length;}

    public Object palabrasTotales(String text){
        String word[] = text.split("[ \\n(/)\"\t\\t\n,?.!]+");
        return word.length;
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        Document document = rows.getElement(rowIndex);
        switch (cols[columnIndex]){
            case NOMBRE: return document.getName();
            case TYPE: return document.getType();
            case CANTIDADDEPALABRAS: return palabrasTotales(document.getText1());
            case FECHA: return document.getDate();
            default: return "";
        }
    }
    public static final int NOMBRE = 0;
    public static final int TYPE = 1;
    public static final int CANTIDADDEPALABRAS = 2;
    public static final int FECHA = 3;
    String [] colNames = new String [4];
    private void initColNames(){
        colNames[NOMBRE] = "Name";
        colNames[TYPE] = "Type";
        colNames[CANTIDADDEPALABRAS] = "Words Found";
        colNames[FECHA] = "Date";
    }
}