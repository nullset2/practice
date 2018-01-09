import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static Map<Integer, Long> fiboResults = new HashMap<>();

    //returns the n-th term of the fibonacci series
    public static long fibonacci(int n){
        if(!fiboResults.containsKey(0) && !fiboResults.containsKey(1)) {
            fiboResults.put(0, 0l);
            fiboResults.put(1, 1l);
        }

        if(!fiboResults.containsKey(n)) fiboResults.put(n, fibonacci(n-1) + fibonacci(n-2));
        return fiboResults.get(n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            System.out.println(fibonacci(n));
        }
    }
}
