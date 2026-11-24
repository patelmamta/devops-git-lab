package main.java.com.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> cells;

    public Board(int dimension) {
        this.setDimension(dimension);
        this.cells = new ArrayList<>();

        for(int i = 0; i < dimension; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < dimension; j++) {
                Cell cell = new Cell(i, j);
                cell.setCellState(CellState.EMPTY);
                row.add(cell);
            }
            this.cells.add(row);
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public void display() {
        for(List<Cell> cellList : this.getCells()) {
            for(Cell cell : cellList) {
                cell.display();
            }
            System.out.println();
        }
    }
}
