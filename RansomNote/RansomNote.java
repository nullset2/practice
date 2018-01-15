import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RansomNote {
    
    public static String canMakeNote(String[] magazine, String[] note){
        Map<String, Integer> magazineCount = new HashMap<String, Integer>();
        Map<String, Integer> inputCount = new HashMap<String, Integer>();
        
        for(String word: magazine){
            if(magazineCount.containsKey(word)){
                magazineCount.put(word, magazineCount.get(word) + 1);
            } else { magazineCount.put(word, 1); }
        }

        for(String word: note){
            if(!magazineCount.containsKey(word)){
                return "No";
            }
            else{
                magazineCount.put(word, magazineCount.get(word) - 1);
                if(magazineCount.get(word) < 0)
                    return "No";
            }
        }
        
        return "Yes";
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        System.out.println(canMakeNote(magazine, ransom));
    }
}

