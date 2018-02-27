package org.jalfredo;

public class Main {

    public static void main(String[] args) {
        Game game = new Game('O'); //O starts

        do{
            game.play();
        }while(game.stillRunning());

        game.showResults();

    }
}
