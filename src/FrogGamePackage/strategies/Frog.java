package FrogGamePackage.strategies;

// Frog.java
public class Frog {
    private String symbol;
    private int position;

    public Frog(String symbol) {
        this.symbol = symbol;
        this.position = -1; // Initial position, not on the board
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

