import java.util.*;
class Solution {
    public static int calPoints(String[] ops) {
        int score = 0;
        Stack<Integer> validRounds = new Stack<Integer>();
        for(int i = 0; i < ops.length; i++){
            System.out.println(score);
            if(ops[i].equals("C")){
                score -= validRounds.pop();
            }
            else if(ops[i].equals("D")){
                int doubleOfLast = validRounds.peek() * 2;
                validRounds.push(doubleOfLast);
                score += doubleOfLast;
            }
            else if(ops[i].equals("+")){
                int n = validRounds.size();
                int temp = validRounds.pop();
                int aggregate = temp + validRounds.peek();
                validRounds.push(temp);
                validRounds.push(aggregate);
                score += aggregate;
            }
            else{
                score += Integer.parseInt(ops[i]);
                validRounds.push(Integer.parseInt(ops[i]));
            }
        }
        return score;
    }

    public static void main(String[] args){
        String[] input = {"5", "2", "C", "D", "+"};
        //String[] input = {"5","-2","4","C","D","9","+","+" };
        System.out.println(calPoints(input));
    }
}
