package main.java.com.strategies;

import main.java.com.models.Game;
import main.java.com.models.Move;
import main.java.com.models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColumnWiningStrategy implements WiningStrategy {
    List<Map<Symbol, Integer>> colCount = new ArrayList<>();

    public ColumnWiningStrategy(int n) {
        for(int i = 0; i < 3; i++) {
            Map<Symbol, Integer> map = new HashMap<>();
            colCount.add(map);
        }
    }

    @Override
    public boolean checkWinner(Move move, int n) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        Map<Symbol, Integer> map = colCount.get(col);
        map.putIfAbsent(symbol, 0);
        map.put(symbol, map.get(symbol) + 1);
        if(map.get(symbol) == n) {
            return true;
        }
        return false;
    }

}
