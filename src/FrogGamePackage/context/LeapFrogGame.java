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

    public void setMove(int column, int row) {
        leapFrogGame.setMove(column, row);
    }

    public void displayBoardGame(String[][] array) {
        leapFrogGame.displayBoardGame(array);
    }

    public void fillBoardGame(String[][] array) {
        leapFrogGame.fillBoardGame(array);
    }

    public void displayScore() {
        leapFrogGame.displayScore();
    }

}
