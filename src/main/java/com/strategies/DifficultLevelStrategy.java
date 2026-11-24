package main.java.com.strategies;


import main.java.com.models.Board;
import main.java.com.models.Move;
import main.java.com.models.Symbol;

public interface DifficultLevelStrategy {
    public Move makeMove(Board board, Symbol symbol);
}
