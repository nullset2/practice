import java.util.Scanner;

public class Main {

    static Trie trie = new Trie();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();

            if(op.equals("add")){
                trie.insert(contact);
            }else if(op.equals("find")){
                System.out.println(trie.countStartingWith(contact));
            }
        }

    }
}
