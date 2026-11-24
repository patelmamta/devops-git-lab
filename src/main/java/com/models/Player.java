package main.java.com.models;

import javax.management.InvalidAttributeValueException;
import java.util.Scanner;

public abstract class Player {
    public String name;
    public Symbol symbol;
    public Scanner scanner;

    public Player() {
        scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public abstract Move makeMove(Board board);
}
