package main.java.com.strategies;

import main.java.com.models.*;

import java.util.List;

public class EasyDifficultLevelStrategy implements DifficultLevelStrategy {
    @Override
    public Move makeMove(Board board, Symbol symbol) {
        int n = board.getDimension();
        System.out.println("Number" + n);
        Cell emptyCell = null;
        System.out.println(board.getCells().size());
        for(List<Cell> cellList : board.getCells()) {
            for(Cell cell : cellList) {
                System.out.println("cell state" + cell.getCellState());
                if (cell.getCellState() == CellState.EMPTY) {
                    Move move = new Move();
                    emptyCell = cell;
                    emptyCell.setCellState(CellState.FILLED);
                    emptyCell.setSymbol(symbol);
                    move.setCell(emptyCell);
                    System.out.println(move.getCell().getCol() + " Move " );
                    return move;
                }
            }
        }
        return null;

    }
}
