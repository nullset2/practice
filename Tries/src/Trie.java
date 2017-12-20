import java.util.HashMap;
import java.util.Map;

public class Trie {
    private Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String word){
        HashMap<Character, Node> children = root.children;
        int l = word.length();

        for (int i = 0; i<l; i++){
            char c = word.charAt(i);

            Node n; //get the current node

            if(children.containsKey(c))
                n = children.get(c);
            else{
                n = new Node(c);
                children.put(c, n);
            }

            children = n.children; //move one level down

            if(i == l-1)
                n.leaf = true;
        }
    }

    /*
    Will return whether at least one word starting with a certain prefix exists in the Trie
     */
    public boolean startsWith(String prefix){
        if(searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public int countStartingWith(String prefix){
        Node found = searchNode(prefix);
        if(found != null)
            return found.children.size();

        return 0;
    }

    public boolean search(String word){
        Node found = searchNode(word);

        if(found != null && found.leaf) return true;

        return false;
    }

    /*
    Will seek through the Trie and, if and only if the word is found in the trie such that it's not a subword of
    another, will return the last node of the word.
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
