import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IceCreamBinsearch {
    public static int find(int[] flavors, int difference, int low, int top){
        if(top < low) return -1;
        int mid = (top + low)/2;
        if(flavors[mid] == difference) return mid;
        if(difference > flavors[mid]){
            return find(flavors, difference, mid, top);
        }
        return find(flavors, difference, low, mid);
    }
    public static int[] getFlavors(int[] flavors, int money){
        for(int i = 0; i < flavors.length; i++){
            int j = find(flavors, money - flavors[i], 0, flavors.length-1); 
            if(j > 0) return new int[] {i+1, j+1};
        }
        return new int[] {-1, -1}; 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }

            Arrays.sort(a);
            
            int[] flavors = getFlavors(a, m);
            
            System.out.println(String.format("%d %d", flavors[0], flavors[1]));
        }
    }
}
