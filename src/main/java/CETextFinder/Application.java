package CETextFinder;

import CETextFinder.EstructurasDeDatos.ArbolBinario.AVLBinaryTree;
import CETextFinder.EstructurasDeDatos.ArbolBinario.BinaryTree;
import CETextFinder.EstructurasDeDatos.ArbolBinario.OccurenceList;
import CETextFinder.EstructurasDeDatos.ArbolBinario.OccurenceNode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Application {
    public static void main(String[] args){
        //new Application();
        OccurenceList A = new OccurenceList(); //PRUEBAS
        // AGREGAMOS LOS DATOS QUE QUERAMOS, NOTA EL RADIXSORT SOLO FUNCIONA CON NUMEROS
        A.addOccurence("2");
        A.addOccurence("1");
        A.addOccurence("3");

        // VERIFICAMOS LA LISTA AGREGADA
        System.out.println("Antes");
        OccurenceNode current = A.getHead();
        while (current != null){
            System.out.println(current.getOccurence());
            current = current.getNext();
        }
        // ELEGIMOS EL TIPO DE ORDENAMIENTO (QuickSort, BubbleSort, RadixSort), NOTA EL RADIXSORT SOLO FUNCIONA CON NUMEROS
        RadixSort(A,A.getLenth());

        // VERIFICAMOS LA LISTA ORDENADA
        current = A.getHead();
        System.out.println("Despues");
        while (current != null){
            System.out.println(current.getOccurence());
            current = current.getNext();
        }
    }
    public static OccurenceNode getElement(OccurenceList list, int i){
        OccurenceNode current = list.getHead();
        for (int a = 0; a < i; a++)
        {
            current = current.getNext();
        }
        return current;
    }
    public static void exchange(OccurenceList list, OccurenceNode i, OccurenceNode j){
        if (i.equals(list.getHead())) {
            OccurenceNode i2 = new OccurenceNode(i.getOccurence());
            OccurenceNode j2 = new OccurenceNode(j.getOccurence());
            if (j.getPrevious() != null) {
                i2.setPrevious(j.getPrevious());
                j.getPrevious().setNext(i2);
            }
            if (j.getNext() != null) {
                j.getNext().setPrevious(i2);
            }
            i2.setNext(j.getNext());

            if (i.getPrevious() != null) {
                j2.setPrevious(j.getPrevious());
                i.getPrevious().setNext(j2);
            }
            if (i.getNext() != null) {
                i.getNext().setPrevious(j2);
            }
            j2.setNext(i.getNext());
            list.setHead(j2);
        }
        else{
            OccurenceNode i2 = new OccurenceNode(i.getOccurence());
            OccurenceNode j2 = new OccurenceNode(j.getOccurence());
            if (j.getPrevious() != null) {
                i2.setPrevious(j.getPrevious());
                j.getPrevious().setNext(i2);
            }
            if (j.getNext() != null) {
                j.getNext().setPrevious(i2);
            }
            i2.setNext(j.getNext());
            if (i.getPrevious() != null) {
                j2.setPrevious(i.getPrevious());
                i.getPrevious().setNext(j2);
            }
            if (i.getNext() != null) {
                i.getNext().setPrevious(j2);
            }
            j2.setNext(i.getNext());
        }
    }
    public static void QuickSort(OccurenceList list, int low, int high){

        int i = low, j = high;
        OccurenceNode pivot = getElement(list,low + ((high - low)/2));
        while (i <= j) {
            while (getElement(list,i).getOccurence().compareTo(pivot.getOccurence()) < 0) {
                i++;
            }
            while (getElement(list,j).getOccurence().compareTo(pivot.getOccurence()) > 0) {
                j--;
            }
            if (i <= j) {
                exchange(list, getElement(list,i), getElement(list,j));
                i++;
                j--;
            }
        }
        if (low < j)
        {
            QuickSort(list, low, j);
        }
        if (i < high)
        {
            QuickSort(list, i, high);
        }
    }
    public static void BubbleSort(OccurenceList list){
        int in;
        int out;
        for (out = list.getLenth() - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (getElement(list,in).getOccurence().compareTo(getElement(list,in+1).getOccurence()) > 0) {
                    exchange(list ,getElement(list,in), getElement(list,in+1));
                }
            }
        }
    }
    public static int getMax(OccurenceList list){
        int max = 0;
        OccurenceNode current = list.getHead();
        while (current != null){
            if (max < Integer.parseInt(current.getOccurence()))
            {
                max = Integer.parseInt(current.getOccurence());
            }
            current = current.getNext();
        }
        return max;
    }
    public static void RadixSort(OccurenceList list, int n){
            int m = getMax(list);
            for (int exp = 1; m/exp > 0; exp *= 10) {
                countSort(list, n, exp);
            }
    }
    static void countSort(OccurenceList list, int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        for (i = 0; i < n; i++) {
            count[(Integer.parseInt(getElement(list, i).getOccurence()) / exp) % 10]++;
        }
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (i = n - 1; i >= 0; i--) {
            output[count[ (Integer.parseInt(getElement(list,i).getOccurence())/exp)%10 ] - 1] = Integer.parseInt(getElement(list,i).getOccurence());
            count[ (Integer.parseInt(getElement(list,i).getOccurence())/exp)%10 ]--;
        }
        OccurenceNode current = list.getHead();
        i = 0;
        while (current != null){
            current.setOccurence(String.valueOf(output[i]));
            i++;
            current = current.getNext();
        }
    }
    public void Application() {
        try {
            /* Se crea el socket cliente */
            Socket socket = new Socket("localhost", 25557);
            System.out.println("conectado");

            /* Se hace que el cierre espere a la recogida de todos los datos desde
             * el otro lado */
            socket.setSoLinger(true, 10);

            /* Se obtiene un stream de lectura para leer objetos */
            DataInputStream bufferEntrada =
                    new DataInputStream(socket.getInputStream());

            /* Se lee un Datosocket que nos envía el servidor y se muestra
             * en pantalla */
            DatoSocket dato = new DatoSocket("");
            dato.readObject(bufferEntrada);
            System.out.println("Cliente Java: Recibido " + dato.toString());

            /* Se obtiene un flujo de envio de datos para enviar un dato al servidor */
            DataOutputStream bufferSalida =
                    new DataOutputStream(socket.getOutputStream());

            /* Se crea el dato y se escribe en el flujo de salida */
            DatoSocket aux = new DatoSocket("Adios");
            aux.writeObject(bufferSalida);

            System.out.println("Cliente Java: Enviado " + aux.toString());

             /* La llamada a setSoLinger() hará que el cierre espere a que el otro
             lado retire los datos que hemos enviado */
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
