package CETextFinder;

import CETextFinder.EstructurasDeDatos.ArbolBinario.BinaryTree;

public class Application {
    public static void main(String[] args){
        BinaryTree A = new BinaryTree<>();
        A.insert("Hola","Hola como estas");
        A.insert("Hola,","Hola, como estas");
        A.insert("Hola","Hola es un gusto");
        A.contains("Hola");
    }
}
