import java.util.HashMap;

public class Node {
    public char c;
    protected HashMap<Character, Node> children = new HashMap<>();
    public int size;
    public boolean leaf;

    public Node(){}

    public Node(char c){ this.c = c; }


    0b000110101
}
