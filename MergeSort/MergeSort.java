import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MergeSort {
    
    static void merge(int[] arr, int l, int m, int r){
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for(i = 0; i < n1; ++i)
            L[i] = arr[l+i];
        
        for(j = 0; j < n2; ++j)
            R[j] = arr[m+1+j];
        
        i = j = 0;
        k = l;
        
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int[] array, int low, int high){
        if(low < high){
            int mid = low + (high - low)/2;
            mergeSort(array, low, mid);
            mergeSort(array, mid+1, high);
            merge(array, low, mid, high);
        }
    }
       
    static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            mergeSort(arr);
            System.out.println(Arrays.toString(arr));
        }
        in.close();
    }
}
