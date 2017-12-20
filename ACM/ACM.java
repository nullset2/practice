import java.util.Scanner;
import java.util.Arrays;

class ACM {
    static int calculateOr(int[] knowledge1, int[] knowledge2){
        int count = 0;
        int m = knowledge1.length;
        for(int i = 0; i < m; i++){
            if((knowledge1[i] | knowledge2[i]) == 1)
                ++count;
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.nextLine();

        int[][] knowledge = new int[n][m];

        for(int i = 0; i < n; i++){
            knowledge[i] = sc.nextLine().chars().map(x -> x - '0').toArray();
        }

        int maxSubjects = -1;
        int satisfactoryTeams = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int currentNumberOfSubjects = calculateOr(knowledge[i], knowledge[j]);

                if(currentNumberOfSubjects > maxSubjects)
                    maxSubjects = currentNumberOfSubjects;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int currentNumberOfSubjects = calculateOr(knowledge[i], knowledge[j]);

                if(currentNumberOfSubjects == maxSubjects)
                    ++satisfactoryTeams;
            }
        }

        System.out.println(maxSubjects);
        System.out.println(satisfactoryTeams);
    }
}
