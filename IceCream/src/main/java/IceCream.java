import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IceCream {

    public static int[] getFlavors(int[] flavors, int money){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < flavors.length; i++){
            if(!map.isEmpty() && map.containsKey(money-flavors[i])) {
                return new int[] {map.get(money-flavors[i])+1, i+1 };
            }
            map.put(flavors[i], i);
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
            
            int[] flavors = getFlavors(a, m);
            
            System.out.println(String.format("%d %d", flavors[0], flavors[1]));
        }
    }
}
