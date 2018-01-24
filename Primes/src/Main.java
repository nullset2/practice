import java.util.Scanner;

public class Main {

    static boolean isPrime(int n){
        if(n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            System.out.println(isPrime(sc.nextInt()) ? "Prime" : "Not prime");
        }
    }
}
