package main.java.com.models;

import javax.management.InvalidAttributeValueException;
import main.java.com.factories.WiningStartegyFactory;
import main.java.com.strategies.WiningStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerIndex;
    private List<WiningStrategy> winingStrategyList;
    private GameState state;
    private Player winner;
    private List<Move> moves;

    private Game( GameBuilder gameBuilder) {
        Board board = new Board(gameBuilder.getDimension());
        this.setBoard(board);
        this.setPlayers(gameBuilder.getPlayers());
        this.winingStrategyList = new ArrayList<>();
        for(WiningStrategyType winingStrategyType : gameBuilder.getWiningStrategyList()) {
            this.winingStrategyList.add(WiningStartegyFactory.getFactory(winingStrategyType, gameBuilder.getDimension()));
        }
        this.nextPlayerIndex = 0;
        this.setState(GameState.IN_PROGRESS);
        this.moves = new ArrayList<>();

    }

    public void makeMove() throws InvalidAttributeValueException {

        // get player
        Player player = players.get(nextPlayerIndex);
        System.out.println("Now " + player.getName() + " turn:");

        // player move
        Move move = player.makeMove(this.getBoard());
        System.out.println("Move + " + move.getPlayer().getName());
        if(move == null) {
            throw new InvalidAttributeValueException("Not properly select cell");
        }
        this.moves.add(move);
        //checkWinner
        for(WiningStrategy winingStrategy : this.getWiningStrategyList() ) {
            if(winingStrategy.checkWinner(move, this.getBoard().getDimension())) {

                this.setState(GameState.WIN);
                this.setWinner(player);
                break;
            }
        }

        // if not check draw
        if(this.getState() == GameState.IN_PROGRESS) {
            if(this.moves.size() == this.getBoard().getDimension() * this.getBoard().getDimension()) {
                this.setState(GameState.DRAW);
                this.setWinner(null);
            }
        }
        // update for next move
        nextPlayerIndex++;
        nextPlayerIndex = nextPlayerIndex % players.size();
    }

    public void undoLastMove() {
        Move lastMove = this.getMoves().getLast();
        Cell cell = lastMove.getCell();
        cell.setCellState(CellState.EMPTY);
        cell.setSymbol(null);
        this.setState(GameState.IN_PROGRESS);
        this.getMoves().remove(lastMove);
        this.setWinner(null);
        this.setNextPlayerIndex((nextPlayerIndex - 1 + players.size())%players.size());
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void displayBoard() {
        this.board.display();
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<WiningStrategy> getWiningStrategyList() {
        return winingStrategyList;
    }

    public void setWiningStrategyList(List<WiningStrategy> winingStrategyList) {
        this.winingStrategyList = winingStrategyList;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public static class GameBuilder {
        private List<Player> players;
        private int dimension;
        private List<WiningStrategyType> winingStrategyTypeList;

        public List<Player> getPlayers() {
            return players;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public int getDimension() {
            return dimension;
        }

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<WiningStrategyType> getWiningStrategyList() {
            return winingStrategyTypeList;
        }

        public GameBuilder setWiningStrategyList(List<WiningStrategyType> winingStrategyTypeList) {
            this.winingStrategyTypeList = winingStrategyTypeList;
            return this;
        }

        public Game build(){
            return new Game(this);
        }
    }

}
