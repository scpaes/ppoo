package FrogGamePackage.main;

import FrogGamePackage.context.LeapFrogGame;
import FrogGamePackage.strategies.Froglet;


public class Main {
    public static void main(String[] args) {
        LeapFrogGame leapFrogGame = new LeapFrogGame(new Froglet());
        leapFrogGame.play();
    }
}

