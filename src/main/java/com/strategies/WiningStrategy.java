package main.java.com.strategies;

import main.java.com.models.Game;
import main.java.com.models.Move;


public interface WiningStrategy {
    public boolean checkWinner(Move move, int n);
}
