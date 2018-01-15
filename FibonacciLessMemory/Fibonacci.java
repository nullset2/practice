import java.util.*;

class Fibonacci{
    static int getFiboTerm(int n, int[] memo){
        if(memo[n] == -1)
            memo[n] = getFiboTerm(n-1, memo) + getFiboTerm(n-2, memo);

        return memo[n];
    }

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int[] memo = new int[n+1];

        memo[0] = 0;
        memo[1] = 1;

        for(int i = 2; i < n+1; i++)
            memo[i] = -1;

        getFiboTerm(n, memo);
        System.out.println(Arrays.toString(memo));
    }
}
