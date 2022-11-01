package TextFinder.Logic.SortAlgorithms;
import java.util.Arrays;

public class RadixSort {

    private static int[] numberOfWords;
    private static int length;
    private static String[] links;

    public static void radixSort(int array[], String array2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        numberOfWords = array;
        links = array2;
        length = array.length;
        radixsort(array, length);
    }

    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array

        String output2[] = new String[n]; // output array 2 of links

        String arr2[] = links; //arr2 of the links

        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            output2[count[(arr[i] / exp) % 10] -1] = arr2[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++){
            arr[i] = output[i];
            arr2[i] = output2[i];
        }
        links = arr2;
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10){
            countSort(arr, n, exp);
        }
    }

    // A utility function to print an array
    public static void print(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static int[] getNumberOfWords() {return numberOfWords;}

    public static void setNumberOfWords(int[] numberOfWords) {RadixSort.numberOfWords = numberOfWords;}

    public static String[] getLinks() {return links;}

    public static void setLinks(String[] links) {RadixSort.links = links;}
}
