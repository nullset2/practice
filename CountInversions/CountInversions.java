import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }
        in.close();
    }

    private static long countInversions(int[] numbers) {
        int[] aux = numbers.clone();
        return countInversions(numbers, 0, numbers.length - 1, aux);
    }

    private static long countInversions(int[] arr, int low, int high, int[] aux) {
        if(high <= low) return 0;

        int mid = low + (high - low) / 2;

        long count = 0;

        count += countInversions(aux, low, mid, arr);
        count += countInversions(aux, mid+1, high, arr);
        count += merge(arr, low, mid, high, aux);

        return count;
    }

    private static long merge(int[] arr, int low, int mid, int high, int[] aux){
        long count = 0;
        int i = low, j = mid + 1, k = low;

        while(i <= mid || j <= high){
            if(i > mid)
                arr[k++] = aux[j++];
            else if(j > high)
                arr[k++] = aux[i++];
            else if(aux[i] <= aux[j])
                arr[k++] = aux[i++];
            else {
                arr[k++] = aux[j++];
                count += mid + 1 - i;
            }
        }

        return count;
    }
}