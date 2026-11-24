package main.java.com.models;

import javax.management.InvalidAttributeValueException;
import main.java.com.validators.ValidateCell;

public class Human extends  Player{
    private String email;
    private String password;

    public Human() {

//        char ch = scanner.next().charAt(0);
//        Symbol sy = new Symbol();
//        sy.setSymbol(ch);
//        this.setSymbol(sy);
    }

    public Move makeMove(Board board) {
        System.out.println("You have three times get chance if you select wrong cell from the board");
        int row = -1;
        int col = -1;
        for(int i = 1; i <= 3; i++) {
            System.out.println("Select row from the Game board");
            row = scanner.nextInt();
            System.out.println("Select column from the Game Board");
            col = scanner.nextInt();
            if(ValidateCell.validate(row, col)){
                break;
            }

        }
        if(row == -1 || col == -1) {
           return null;
        }
        System.out.println("row + col " +  row + " " + col);

        Cell cell = board.getCells().get(row).get(col);
        cell.setSymbol(this.getSymbol());
        cell.setCellState(CellState.FILLED);
        Move move = new Move();
        move.setPlayer(this);
        move.setCell(cell);
        return move;
    }
}
