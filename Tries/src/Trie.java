import java.util.HashMap;
import java.util.Map;

public class Trie {
    private Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node current = root;
        int l = word.length();

        for (int i = 0; i<l; i++){
            char c = word.charAt(i);
            current.children.putIfAbsent(c, new Node());
            current = current.children.get(c);
            current.size++;

            if(i == l-1)
                current.leaf = true;
        }
    }

    public int countStartingWith(String prefix){
        Node found = searchNode(prefix);
        if(found != null)
            return found.size;

        return 0;
    }

    /*
    Will seek through the Trie and, will return the last node of the word.
    Else, it will return null.
     */
    public Node searchNode(String s){
        Map<Character, Node> children = root.children;
        Node n = null;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(children.containsKey(c)){
                n = children.get(c);
                children = n.children;
            }else {
                return null;
            }
        }

        return n;
    }
}
