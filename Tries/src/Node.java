import java.util.HashMap;

public class Node {
    char c;
    HashMap<Character, Node> children = new HashMap<>();
    boolean leaf;

    public Node(){}

    public Node(char c){ this.c = c; }
}
