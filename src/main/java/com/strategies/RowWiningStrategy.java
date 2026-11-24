package main.java.com.strategies;

import main.java.com.models.Game;
import main.java.com.models.Move;
import main.java.com.models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowWiningStrategy implements WiningStrategy {
    private List<Map<Symbol, Integer>> rowCount = new ArrayList<>();

    public RowWiningStrategy(int n) {
        for(int i = 0; i < n; i++) {
            Map<Symbol, Integer> map = new HashMap<>();
            rowCount.add(map);
        }
    }
    @Override
    public boolean checkWinner(Move move, int n) {

        // put symbol if absent
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        // if get grid
        Map<Symbol, Integer> map = rowCount.get(row);
        map.putIfAbsent(symbol, 0);
        map.put(symbol, map.get(symbol) + 1);
        rowCount.set(row, map);
        if(map.get(symbol) == n) {
            return true;
        }
        return false;
    }

}
