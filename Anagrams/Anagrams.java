import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Anagrams {

    public static int numberNeeded(String first, String second) {
        int[] counts = new int[26];
        int result = 0;

        for(int i = 0; i < first.length(); i++){
            counts[first.charAt(i) - 'a']++;
        }

        for(int i = 0; i < second.length(); i++){
            counts[second.charAt(i) - 'a']--;
        }

        for(int i = 0; i < counts.length; i++){
            result += Math.abs(counts[i]);
        }

        return result;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

