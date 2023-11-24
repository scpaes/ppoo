package FrogGamePackage.main;

import FrogGamePackage.context.LeapFrogGame;
import FrogGamePackage.strategies.Frog;
import FrogGamePackage.strategies.Froglet;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Frog Game! Game is starting...");
        System.out.println("Choose your game mode: (0 - Frog || 1 - Froglet)");

        int gameMode = (scanner.nextInt());
        if (gameMode == 0) {
            LeapFrogGame leapFrogGame = new LeapFrogGame(new Frog());
            leapFrogGame.play();
        } else {
            LeapFrogGame leapFrogFrogletGame = new LeapFrogGame(new Froglet());
            leapFrogFrogletGame.play();
        }
    }
}

