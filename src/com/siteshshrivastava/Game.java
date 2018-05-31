package com.siteshshrivastava;

import java.util.Random;
import java.util.Scanner;

class Game {
    private Move humanMove;
    private Move computerMove;
    private Result result;

    void play(Scanner scanner) {
        System.out.println(
                "1] Paper" + "\n" +
                "2] Rock" + "\n" +
                "3] Scissor" + "\n"
        );
        System.out.print("What's your move? (1/2/3): ");

        do {

            int humanChoice = scanner.nextInt();
            if (humanChoice < 1 || humanChoice > 3) {
                System.out.print("Invalid choice. Please enter again: ");
            } else {
                humanMove = Move.values()[humanChoice - 1];
            }

        } while (humanMove == null);

        computerMove = Move.values()[new Random().nextInt(Move.values().length)];
    }

    void evaluate() {
        System.out.println(
                "Computer's move: " + computerMove + "\n" +
                "Your move      : " + humanMove + "\n"
        );

        this.setResult(humanMove.compareMoves(computerMove));

        switch (this.getResult()) {
            case WIN:
                System.out.println("You win :)");
                break;
            case LOSS:
                System.out.println("Computer wins :(");
                break;
            case TIE:
                System.out.println("It's a tie :|");
                break;
        }

        System.out.println();
    }

    public Result getResult() {
        return this.result;
    }

    private void setResult(Result result) {
        this.result = result;
    }
}
