package org.jalfredo;

public class Board {
    int size;
    char[][] board;

    public Board(int n){
        this.size = n;
        this.board = new char[n][n];
    }

    public void addToBoard(int x, int y, char token){
        if(x < 0 || x >= this.size || y < 0 || y >= this.size || this.board[x][y] != (char)0)
            return;

       this.board[x][y] = token;
    }

    public void print(){
        for(int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                char current = this.board[i][j];
                if (current == (char)0) {
                    current = '-';
                }

                if (j != 0) {
                    System.out.print("|");
                }

                System.out.print(current);

                if (j == this.size - 1)
                    System.out.println();
            }
        }
    }

}
