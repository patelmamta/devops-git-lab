package main.java.com.factories;

import main.java.com.models.WiningStrategyType;
import main.java.com.strategies.*;


public class WiningStartegyFactory {
    public static WiningStrategy getFactory(WiningStrategyType type, int n) {
        WiningStrategy strategy;
        switch(type) {
            case WiningStrategyType.ROW:
                strategy = new RowWiningStrategy(n);
                break;
            case WiningStrategyType.COLUMN:
                strategy = new ColumnWiningStrategy(n);
                break;
            case WiningStrategyType.DIAGONAL:
                strategy = new DiagonalWiningStrategy(n);
                break;
            default:
                strategy = new CornerWiningStrategy(n);
                break;

        }
        return strategy;
    }
}
