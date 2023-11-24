package FrogGamePackage.strategies;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

// Frog.java
public class Frog implements LeapFrogGameInterface {
    String[][] boardGame;
    int size = 6;
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

    @Override
    public boolean isWithinBounds(int column, int row) {
        return column >= 0 && column <= 5 && row >= 0 && row <= 5;
    }

    @Override
    public boolean isEmptySpace(int column, int row) {
        return Objects.equals(this.boardGame[row][column], " ");
    }

    @Override
    public boolean isAdjacent(int columnStart, int rowStart, int columnEnd, int rowEnd) {
        return (Math.abs(columnStart - columnEnd) == 1 && Math.abs(rowStart - rowEnd) == 0) ||
                (Math.abs(columnStart - columnEnd) == 0 && Math.abs(rowStart - rowEnd) == 1);
    }

    @Override
    public boolean hasPieceBetween(int columnStart, int rowStart, int columnEnd, int rowEnd) {
        if (columnStart == columnEnd) {
            // Moving up or down
            int rowBetween = (rowStart + rowEnd) / 2;
            return !isEmptySpace(columnStart, rowBetween);
        } else {
            // Moving left or right
            int columnBetween = (columnStart + columnEnd) / 2;
            return !isEmptySpace(columnBetween, rowStart);
        }
    }

    @Override
    public boolean gameIsOver() {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (!isEmptySpace(col, row)) {
                    // Check all four directions
                    if ((isWithinBounds(col, row - 1) && isEmptySpace(col, row - 1) && isValidMove(col, row, col, row - 1)) ||
                            (isWithinBounds(col, row + 1) && isEmptySpace(col, row + 1) && isValidMove(col, row, col, row + 1)) ||
                            (isWithinBounds(col - 1, row) && isEmptySpace(col - 1, row) && isValidMove(col, row, col - 1, row)) ||
                            (isWithinBounds(col + 1, row) && isEmptySpace(col + 1, row) && isValidMove(col, row, col + 1, row))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    @Override
    public boolean isValidMove(int columnStart, int rowStart, int columnEnd, int rowEnd) {
        if (!isValidStartingPosition(columnStart, rowStart) ||
                !isValidEndingPosition(columnEnd, rowEnd) ||
                isAdjacent(columnStart, rowStart, columnEnd, rowEnd) ||
                !hasPieceBetween(columnStart, rowStart, columnEnd, rowEnd)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean setMove(int columnStart, int rowStart, int columnEnd, int rowEnd) {
        if (isValidMove(columnStart, rowStart, columnEnd, rowEnd)) {
            this.boardGame[rowStart][columnStart] = " ";
            this.boardGame[rowEnd][columnEnd] = "#";
            if (columnStart == columnEnd) {
                // Moving up or down
                int rowBetween = (rowStart + rowEnd) / 2;
                this.boardGame[rowBetween][columnStart] = " ";
            } else {
                // Moving left or right
                int columnBetween = (columnStart + columnEnd) / 2;
                this.boardGame[rowStart][columnBetween] = " ";
            }
            return true;
        } else {
            System.out.println("Invalid move!");
        }
        return false;
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
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        int rowStart;
        int columnStart;
        int rowEnd;
        int columnEnd;
        boolean scorePoint;
        while (!gameOver) {
            System.out.println("Player 1, enter your move (row column): ");
            rowStart = scanner.nextInt();
            columnStart = scanner.nextInt();

            System.out.println("Player 1, enter your move (row column): ");
            rowEnd = scanner.nextInt();
            columnEnd = scanner.nextInt();

            scorePoint = this.setMove(columnStart, rowStart, columnEnd, rowEnd);
            if (scorePoint) {
                this.scorePlayer1++;
            }
            this.displayScore();
            this.displayBoardGame(this.boardGame);

            System.out.println("Player 2, enter your move (row column): ");
            rowStart = scanner.nextInt();
            columnStart = scanner.nextInt();

            System.out.println("Player 2, enter your move (row column): ");
            rowEnd = scanner.nextInt();
            columnEnd = scanner.nextInt();

            scorePoint = this.setMove(columnStart, rowStart, columnEnd, rowEnd);
            if (scorePoint) {
                this.scorePlayer2++;
            }
            this.displayScore();
            this.displayBoardGame(this.boardGame);
            gameOver = !this.gameIsOver();
        }
    }
}
