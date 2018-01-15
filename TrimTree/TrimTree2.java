import java.util.*;

class Node{
    int val;
    Node left;
    Node right;

    public Node(int x){ val = x; }
}

class TrimTree2{

    static Node trimTree(Node root, int L, int R){
        if(root == null) return null;
        
        root.left = trimTree(root.left, L, R);
        root.right = trimTree(root.right, L, R);

        if(root.val < L)
            return trimTree(root.right, L, R);
        else if(root.val > R)
            return trimTree(root.left, L, R);

        return root;
    }

    static void inorderTraversal(Node root){
        if(root == null) return;
        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
    }

    static ArrayList<Integer> traverse(Node root, int goal, ArrayList<Integer> soFar){
        if(root == null) return new ArrayList<Integer>();
        soFar.add(root.val);
        if(root.val == goal)
            return soFar;
        else if(root.val < goal)
            return traverse(root.right, goal, soFar);
       return traverse(root.left, goal, soFar);
    }

    static int findNCA(Node root, int first, int second){
        ArrayList<Integer> path1 = traverse(root, first, new ArrayList<Integer>()); 
        ArrayList<Integer> path2 = traverse(root, second, new ArrayList<Integer>());

       Collections.sort(path1);
       Collections.sort(path2);
        
        int i = 0, j = 0;

        while(i<path1.size() && j<path2.size()){
            if(path1.get(i) == path2.get(j)) return path1.get(i); //solution is found
            else if(path1.get(i) > path2.get(j)) j++;
            else i++;
        } 

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args){
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        //Node trimmed = trimTree(root, 2, 5);

        inorderTraversal(root);
        //inorderTraversal(trimmed);

        System.out.println(findNCA(root, 2, 6));
    }
}

