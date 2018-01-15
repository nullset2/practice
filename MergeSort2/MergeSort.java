import java.util.*;

public class MergeSort{
    static int swaps = 0;

    public static int[] merge(int[] lower, int[] higher){
        int[] aux = new int[lower.length + higher.length];
        int i = 0, j = 0;

        for(int k = 0; k < aux.length; k++){
            if(i >= lower.length){
                aux[k] = higher[j++];
            }
            else if(j >= higher.length){
                aux[k] = lower[i++];
            }
            else if(lower[i] <= higher[j]){
                aux[k] = lower[i++];
            }
            else{
                aux[k] = higher[j++];
            }
        }
        return aux;
    }

    public static int[] mergeSort(int[] array){
        int n = array.length;
        if(n == 1) return array;
        int[] lower = new int[n/2];
        int[] higher = new int[n - n/2];

        for(int i = 0; i < lower.length; i++)
            lower[i] = array[i];

        for(int i = 0; i < higher.length; i++)
            higher[i] = array[i + n/2];

        return merge(mergeSort(lower), mergeSort(higher));
    }

    public static void main(String[] args){
        int[] input = {35, 30, 25, 20, 15, 10, 5};
        System.out.println(String.format("Array: %s\n", Arrays.toString(input)));
        int[] sorted = mergeSort(input);
        System.out.println(String.format("Sorted: %s\nWith %d inversions!", Arrays.toString(sorted), swaps));
    }
}
