package main.java.com.models;

public class Cell {
    private int row;
    private int col;
    private Symbol symbol;
    private CellState cellState;

    public Cell(int row, int col) {
        this.setRow(row);
        this.setCol(col);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public void display() {
        if(this.getCellState() == CellState.EMPTY) {
            System.out.print(" |   | ");
        } else {
            System.out.print(" | " + this.getSymbol().getSymbol() + " | ");
        }
    }
}
