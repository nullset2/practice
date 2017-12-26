import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    private static HashMap<Integer, Integer> solutionMap = new HashMap<>();

    public static int _findNumberOfSolutions(int s, int stepsSoFar) {
        if (stepsSoFar == s)
            return 1;
        else if (stepsSoFar > s)
            return 0;

        int solutions = _findNumberOfSolutions(s, stepsSoFar + 1)
                + _findNumberOfSolutions(s, stepsSoFar + 2)
                + _findNumberOfSolutions(s, stepsSoFar + 3);

        solutionMap.put(s, solutions);

        return solutions;
    }

    public static int findNumberOfSolutions(int s) {
        return _findNumberOfSolutions(s, 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            int solutions = 0;
            if (solutionMap.containsKey(n))
                solutions = solutionMap.get(n);
            else
                solutions = findNumberOfSolutions(n);
            System.out.println(solutions);
        }
    }
}
