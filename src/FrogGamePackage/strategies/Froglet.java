package FrogGamePackage.strategies;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Froglet implements LeapFrogGameInterface {
    String[][] boardGame;
    int scorePlayer1;
    int scorePlayer2;

    @Override
    public void displayScore() {
        System.out.println("Player 1 score: " + this.scorePlayer1);
        System.out.println("Player 2 score: " + this.scorePlayer2);
    }

    @Override
    public boolean isValidStartingPosition(int column, int row) {
        return isWithinBounds(column, row) && !isEmptySpace(column, row);
    }

    @Override
    public boolean isValidEndingPosition(int column, int row) {
        return isWithinBounds(column, row) && isEmptySpace(column, row);
    }

    private boolean isWithinBounds(int column, int row) {
        return column >= 0 && column <= 5 && row >= 0 && row <= 5;
    }

    private boolean isEmptySpace(int column, int row) {
        return Objects.equals(this.boardGame[row][column], " ");
    }

    @Override
    public boolean isValidMove(int columnStart, int rowStart, int columnEnd, int rowEnd) {
        return !(isValidStartingPosition(columnStart, rowStart) && isValidEndingPosition(columnEnd, rowEnd));
    }

    @Override
    public void setMove(int columnStart, int rowStart, int columnEnd, int rowEnd) {
        if (isValidStartingPosition(columnStart, rowStart) && isValidEndingPosition(columnEnd, rowEnd)) {
            this.boardGame[rowStart][columnStart] = " ";
            this.boardGame[rowEnd][columnEnd] = "#";
            this.scorePlayer1++;
        } else if (isValidStartingPosition(columnEnd, rowEnd) && isValidEndingPosition(columnStart, rowStart)) {
            this.boardGame[rowEnd][columnEnd] = " ";
            this.boardGame[rowStart][columnStart] = "#";
            this.scorePlayer2++;
        } else {
            System.out.println("Invalid move");
        }


    }

    @Override
    public void displayBoardGame(String[][] array) {
        // Print column headers
        System.out.print("\t\t");
        for (int j = 0; j < array[0].length; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();

        // Print array with row headers
        for (int i = 0; i < array.length; i++) {
            System.out.print("Row " + i + ":\t");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    @Override
    public void fillBoardGame(String[][] array) {
        // Fill the array with # characters
        for (String[] strings : array) {
            Arrays.fill(strings, "#");
        }
        // remove randomly one character from the array
        Random rand = new Random();
        int row = rand.nextInt(6);
        int col = rand.nextInt(6);
        array[row][col] = " ";
    }

    @Override
    public void play() {
        this.boardGame = new String[6][6];
        this.fillBoardGame(this.boardGame);
        this.displayBoardGame(this.boardGame);

    }
}
