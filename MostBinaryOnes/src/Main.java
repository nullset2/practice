import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int rem;
        int mostOnesSoFar = 0;
        int globalMostOnes = 0;

        while(n > 0){
            rem = n % 2;
            if(rem == 1) {
                ++mostOnesSoFar;
                if(mostOnesSoFar > globalMostOnes){
                    globalMostOnes = mostOnesSoFar;
                }
            }else {
                mostOnesSoFar = 0;
            }
            n = n / 2;
        }
        System.out.println(globalMostOnes);
    }
}
