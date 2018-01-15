import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedString {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < expression.length(); i++){
            char current = expression.charAt(i);
            if(current == '{' || current == '(' || current == '[')
                stack.push(current);
            else if(!stack.isEmpty() && ((current == '}' && stack.peek() == '{')
                  ||(current == ')' && stack.peek() == '(')
                  ||(current == ']' && stack.peek() == '['))
                   )
                stack.pop();
            else return false;
        }
        
        if(stack.isEmpty())
            return true;
        return false;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
