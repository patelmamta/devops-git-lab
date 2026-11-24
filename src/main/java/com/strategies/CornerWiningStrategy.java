package main.java.com.strategies;

import main.java.com.models.Game;
import main.java.com.models.Move;
import main.java.com.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class CornerWiningStrategy implements WiningStrategy {
    Map<Symbol, Integer> cornerCount = new HashMap<>();

    public CornerWiningStrategy(int n) {

    }

    @Override
    public boolean checkWinner(Move move, int n) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        // check the corner and corner i assume that 4 corner for any dimension of board
        if(row == col || (row == n - 1 && col == 0) || (row == 0 && col == n - 1)) {
            Symbol symbol = move.getPlayer().getSymbol();
            cornerCount.putIfAbsent(symbol, 0);
            cornerCount.put(symbol, cornerCount.get(symbol) + 1);
            if(cornerCount.get(symbol) == 4) {
                return true;
            }
        }
        return false;
    }
}
