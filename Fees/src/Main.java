import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] actual = new int[3];
        int[] expected = new int[3];

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++)
            actual[i] = sc.nextInt();

        for(int j = 0; j < 3; j++)
            expected[j] = sc.nextInt();

        int fee = 0;

        if(actual[2] == expected[2]){
            if(actual[1] == expected[1]){
                if(actual[0] > expected[0])
                    fee = 15 * (actual[0] - expected[0]);
            } else {
                fee = 500 * (actual[1] - expected[1]);
            }
        } else {
            fee = 10000;
        }

        System.out.println(fee);

    }
}
