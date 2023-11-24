package FrogGamePackage.context;

import FrogGamePackage.strategies.LeapFrogGameInterface;

public class LeapFrogGame {
    private LeapFrogGameInterface leapFrogGameMode;

    public LeapFrogGame(LeapFrogGameInterface leapFrogGame) {
        this.leapFrogGameMode = leapFrogGame;
    }

    public void play() {
        leapFrogGameMode.play();
    }

}
