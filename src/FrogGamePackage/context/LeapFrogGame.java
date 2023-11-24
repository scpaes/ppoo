package FrogGamePackage.context;

import FrogGamePackage.strategies.LeapFrogGameInterface;

public class LeapFrogGame {
    private LeapFrogGameInterface leapFrogGame;

    public LeapFrogGame(LeapFrogGameInterface leapFrogGame) {
        this.leapFrogGame = leapFrogGame;
    }

    public void play() {
        leapFrogGame.play();
    }

}
