package main.java.com.factories;

import main.java.com.models.DifficultType;
import main.java.com.strategies.DifficultLevelStrategy;
import main.java.com.strategies.EasyDifficultLevelStrategy;
import main.java.com.strategies.HardDifficultLevelStrategy;
import main.java.com.strategies.MediumDifficultLevelStrategy;

import javax.management.InvalidAttributeValueException;

public class DifficultLevelFactory {
    public static DifficultLevelStrategy strategy;

    public static DifficultLevelStrategy getFactory(DifficultType type) {
        DifficultLevelStrategy strategy;
        switch (type) {
            case DifficultType.EASY:
                strategy = new EasyDifficultLevelStrategy();
                break;
            case DifficultType.MEDIUM:
                strategy = new MediumDifficultLevelStrategy();
                break;
            default:
                strategy = new HardDifficultLevelStrategy();
                break;

        }
        return strategy;
    }
}
