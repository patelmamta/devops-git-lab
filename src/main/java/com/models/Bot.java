package main.java.com.models;

import javax.management.InvalidAttributeValueException;
import javax.management.RuntimeErrorException;
import main.java.com.factories.DifficultLevelFactory;
import main.java.com.strategies.DifficultLevelStrategy;
import java.util.List;

public class Bot extends  Player {
    private DifficultType difficultType;
    private DifficultLevelStrategy difficultStrategy;

    public Bot(DifficultType difficultType) {
//        char ch = scanner.next().charAt(0);
//        Symbol sy = new Symbol();
//        sy.setSymbol(ch);
//        this.setSymbol(sy);
        this.difficultStrategy = DifficultLevelFactory.getFactory(difficultType);

    }

    public Move makeMove(Board board) {
        Move move = this.difficultStrategy.makeMove(board, this.getSymbol());
        System.out.println("Move " + move);
        move.setPlayer(this);
        return move;
    }

    public DifficultType getDifficultType() {
        return difficultType;
    }

    public void setDifficultType(DifficultType difficultType) {
        this.difficultType = difficultType;
    }

    public DifficultLevelStrategy getDifficultStrategy() {
        return difficultStrategy;
    }

    public void setDifficultStrategy(DifficultLevelStrategy difficultStrategy) {
        this.difficultStrategy = difficultStrategy;
    }
}
