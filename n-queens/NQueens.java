//given an n*n board, place n queens on the board such as none of them attack any others
//a queen can move as many spaces as it wants on the same row, column or diagonally
//given n, output if n queens can be placed that way on the board

import java.util.*;

class NQueens{
    static boolean isAttacked(int i, int j, int[][] board, int n){
        for(int jj = 0; jj < n; jj++){ //move row-wise
            if(board[i][jj] == 1) return true;
        }

        for(int ii = 0; ii < n; ii++){ //move column-wise
            if(board[ii][j] == 1) return true;
        }

        for(int k = 0; k < n; k++){
            for(int l = 0; l < n; l++){
                if(board[k][l] == 1 && k+l == i+j) return true;
                if(board[k][l] == 1 && k-l == i+j) return true;         
            }
        }
        return false;
    }

    static boolean placeQueen(int[][] board, int n){
        if(n==0) return true;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isAttacked(i, j, board, n)){
                    continue;
                }

                board[i][j] = 1;

                if(placeQueen(board, n-1)) return true;
                
                board[i][j] = 0;

            }
        }

        return false;

    }

    public static void main(String[] args){
        int n = 4;
        int[][] board = new int[n][n];

        System.out.println(placeQueen(board, n));

        for(int i = 0; i < n; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
