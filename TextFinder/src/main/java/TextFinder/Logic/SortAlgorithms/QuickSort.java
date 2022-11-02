package TextFinder.Logic.SortAlgorithms;

public class QuickSort {
    private static String[] names;
    private static String[] links;
    private static int length;

    /**
     * Metodo que se llama inicialmente para desarrollar el código de quicksort
     * @param array
     * @param array2
     */
    public static void sort(String array[], String array2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        names = array;
        links = array2;
        length = array.length;
        quickSort(0, length - 1);
    }

    /**
     * Metodo principal del quicksort
     * @param lowerIndex
     * @param higherIndex
     */
    static void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = names[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (i <= j) {
            while (names[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }

            while (names[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames(i, j);
                i++;
                j--;
            }
        }
        //call quickSort recursively
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    /**
     * Metodo que realiza el cambio de variables
     * @param i
     * @param j
     */
    static void exchangeNames(int i, int j) {
        String temp = names[i];
        names[i] = names[j];
        names[j] = temp;
        String temp2 = links[i];
        links[i] = links[j];
        links[j] = temp2;
    }

    public static String[] getNames() {return names;}

    public static void setNames(String[] names) {QuickSort.names = names;}

    public static String[] getLinks() {return links;}

    public static void setLinks(String[] links) {QuickSort.links = links;}
}
