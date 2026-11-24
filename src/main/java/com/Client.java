package main.java.com;

import main.java.com.models.*;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Game.GameBuilder gameBuilder = new Game.GameBuilder();
        List<WiningStrategyType> types = new ArrayList<>();
        types.add(WiningStrategyType.COLUMN);
        types.add(WiningStrategyType.ROW);
        types.add(WiningStrategyType.DIAGONAL);
        Player player1 = new Human();
        Symbol symbol = new Symbol();
        symbol.setSymbol('X');
        Symbol symbol1 = new Symbol();
        symbol1.setSymbol('O');
        player1.setName("Player 1");
        player1.setSymbol(symbol);
        Player player2 = new Bot(DifficultType.EASY);
        player2.setName("Bot");
        player2.setSymbol(symbol1);
        List<Player> players = List.of(player1, player2);
        Game game = gameBuilder.setDimension(3).setWiningStrategyList(types).setPlayers(players).build();
        Scanner scanner = new Scanner(System.in );
        try {
            while(game.getState() == GameState.IN_PROGRESS){
                game.displayBoard();
                game.makeMove();
                System.out.println("Do you want to undo the previous move? (Y/N)");
                String choice = scanner.nextLine();
                if(choice.equalsIgnoreCase("Y")){
                    game.undoLastMove();
                }
            }
            game.displayBoard();
            if(game.getState() == GameState.WIN){
                System.out.println(game.getWinner().getName() + " has won the game!");
            } else {
                System.out.println("Game is a draw!");
            }
        } catch (InvalidAttributeValueException e) {
            System.out.printf("Move is not happened" + e.getMessage());
        }

    }
}
