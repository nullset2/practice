public class SumOfPrimes {
    static boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    
    static ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        for(int i = 2; i < a; i++){
            if(isPrime(i) && isPrime(a - i)){
                numbers.add(i);
                numbers.add(a - i);
                return numbers;
            }
        }
        return numbers;
    }

    public static void main(String[] args){
        ArrayList<Integer> numbers = primesum((new Scanner(System.in).nextInt()));
        for(int number : numbers){
            System.out.println(number);
        }
    }
}
