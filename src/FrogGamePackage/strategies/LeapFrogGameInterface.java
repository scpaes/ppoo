package FrogGamePackage.strategies;

public interface LeapFrogGameInterface {
    void play();

    boolean setMove(int columnStart, int rowStart, int columnEnd, int rowEnd);

    boolean isValidStartingPosition(int column, int row);

    boolean isValidEndingPosition(int column, int row);

    boolean isValidMove(int columnStart, int rowStart, int columnEnd, int rowEnd);

    void displayBoardGame(String[][] array);

    void fillBoardGame(String[][] array);

    void displayScore();

}
