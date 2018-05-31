package com.siteshshrivastava;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Game> gameHistory = new ArrayList<Game>();

        do {
            System.out.print("Do you want to play Paper-Rock-Scissor? (Y/Yes): ");

            Scanner scanner = new Scanner(System.in);
            String gameChoice = scanner.nextLine().trim().toLowerCase();

            if (!gameChoice.toLowerCase().startsWith("y")) {
                break;
            }

            Game game = new Game();
            game.play(scanner);
            game.evaluate();

            gameHistory.add(game);

        } while (true);

        printStats(gameHistory);

    }

    private static void printStats(List<Game> gameHistory) {
        System.out.println(String.join("", Collections.nCopies(40, "-")));
        System.out.println("RALLY STATS");
        System.out.println(String.join("", Collections.nCopies(40, "-")));


        Map<Result, Integer> gameStats = new EnumMap<Result, Integer>(Result.class);
        for (Game game : gameHistory) {
            Result result = game.getResult();
            gameStats.put(result, gameStats.getOrDefault(result, 0) + 1);
        }

        System.out.println(
                "WON\t\t" +
                "LOST\t\t" +
                "TIED"
        );
        for (Result result : Result.values()) {
            System.out.print(gameStats.getOrDefault(result, 0) + "\t\t");
        }
        System.out.println();
        System.out.println(String.join("", Collections.nCopies(40, "-")));
    }
}

