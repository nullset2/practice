import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    private static HashMap<Integer, Integer> solutionMap = new HashMap<>();

    public static void computeSolutions(int limit){
        solutionMap.put(0, 1);
        solutionMap.put(1, 1);
        solutionMap.put(2, 2);

        for(int i = 3; i <= limit; i++){
            solutionMap.put(i, solutionMap.get(i - 1) + solutionMap.get(i - 2) + solutionMap.get(i - 3));
        }
    }

    public static int findSolutions(int n){
        if(solutionMap.containsKey(n))  return solutionMap.get(n);
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        computeSolutions(36);
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(findSolutions(n));
        }
    }
}


