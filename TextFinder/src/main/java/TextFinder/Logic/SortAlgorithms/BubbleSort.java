package TextFinder.Logic.SortAlgorithms;

import TextFinder.Data_Structures.LinkedList.DoubleLinkedList;
import TextFinder.Data_Structures.LinkedList.Node;
import TextFinder.Logic.Document;

public class BubbleSort {
    private static int[] dates;
    private static int length;
    private static String[] links;

    /**
     * El llamado principal del código de BubbleSort que se desea aplicar
     * @param array
     * @param array2
     */
    public static void bubbleSort(int array[], String array2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        dates = array;
        links = array2;
        length = array.length;
        bubblesort(array, length);
    }

    /**
     * Código que aplica la lógica de BubbleSort
     * @Author Rajat Mishra
     * @param arr
     * @param n
     */
    static void bubblesort(int arr[], int n) {
        String arr2[] = links; //arr2 of the links
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    String temp2 = arr2[j];
                    arr[j] = arr[j + 1];
                    arr2[j] = arr2[j + 1];
                    arr[j + 1] = temp;
                    arr2[j + 1] = temp2;
                }
            }
        }
        links = arr2;
        dates = arr;
    }

    public static int[] getDates() {return dates;}

    public static void setDates(int[] dates) {BubbleSort.dates = dates;}

    public static String[] getLinks() {return links;}

    public static void setLinks(String[] links) {BubbleSort.links = links;}
}
