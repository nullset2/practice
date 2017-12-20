import java.util.*;

public class Main {

    private static long inversions = 0l;

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
            System.out.println(inversions);
            inversions = 0l;
        }
        in.close();
    }

    /*
    we calculate a middle pivot point to sort, which involves allocating two subarrays with a total combined length
    equivalent to the length of the original array
    */
    private static int[] mergeSort(int[] numbers) {
        int n = numbers.length;
        if(n <= 1) return numbers;
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for(int i = 0; i < left.length; i++) {
            left[i] = numbers[i];
        }

        for(int i = 0; i < right.length; i++){
            right[i] = numbers[i+mid];
        }

        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] l, int[] r) {
        int[] merged = new int[l.length + r.length];

        int i = 0, j = 0; //two variables to iterate through both subarrays, i is for left, j is for right

        for (int k = 0; k < merged.length; k++) {
            if(i >= l.length)
                merged[k] = r[j++];
            else if(j >= r.length)
                merged[k] = l[i++];
            else if(l[i] <= r[j]) {
                merged[k] = l[i++];
            }
            else {
                inversions++;
                merged[k] = r[j++];
            }
        }

        return merged;
    }
}
