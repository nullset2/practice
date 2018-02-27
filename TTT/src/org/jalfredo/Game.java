package org.jalfredo;

import java.util.Scanner;

public class Game implements Playable {
    Board board;
    char currentPlayer;
    char winner;
    Scanner sc;

    public Game(char token){
        board = new Board(3);
        currentPlayer = token;
        sc = new Scanner(System.in) ;
    }

    @Override
    public void play(){
        this.print();
        this.query();
    }

    public void query() {
        System.out.print(String.format("(%c plays) ? ? (0-based)> ", currentPlayer));
        this.board.addToBoard(sc.nextInt(), sc.nextInt(), currentPlayer);
        swapCurrentPlayer();
    }

    private void swapCurrentPlayer() {
        if(currentPlayer == 'O')
            currentPlayer = 'X';
        else
            currentPlayer = 'O';
    }

    public boolean stillRunning(){
        return !hasWinner();
    }

    public boolean hasWinner() {
        return this.wins('X') || this.wins('O');
    }

    private boolean wins(char token) {
        //check by row
        for(int i = 0; i < this.board.size; i++)
            for (int j = 0; j < this.board.size; j++) {
                if (this.board.board[i][j] != token)
                    break;
                else if (j == this.board.size - 1) {
                    this.winner = token;
                    return true;
                }
            }

        //check by column
        for(int j = 0; j < this.board.size; j++)
            for(int i = 0; i < this.board.size; i++){
                if(this.board.board[i][j] != token)
                    break;
                else if (i == this.board.size -1){
                    this.winner = token;
                    return true;
                }
            }

        //check diagonals
        int i = 0;

        while(this.board.board[i][i] == token || this.board.board[i][this.board.size-1-i] == token){
            if(i == this.board.size-1){
                this.winner = token;
                return true;
            }
            i++;
        }

        return false;
    }

    public void print() {
        this.board.print();
    }

    public void showResults() {
        this.print();
        System.out.println(String.format("%c wins!", winner));
    }
}
