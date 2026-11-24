package main.java.com.strategies;

import main.java.com.models.Game;
import main.java.com.models.Move;
import main.java.com.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWiningStrategy implements WiningStrategy {

    Map<Symbol, Integer> diagonalCount = new HashMap<>();

    public DiagonalWiningStrategy(int n) {
    }
    @Override
    public boolean checkWinner(Move move, int n) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if(row == col) {
            Symbol symbol = move.getPlayer().getSymbol();
            diagonalCount.putIfAbsent(symbol, 0);
            diagonalCount.put(symbol, diagonalCount.get(symbol) + 1);
            if (diagonalCount.get(symbol) == n) {
                return true;
            }
        }
        return false;
    }
}
