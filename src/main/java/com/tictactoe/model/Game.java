package com.tictactoe.model;


import java.util.HashMap;
import java.util.Map;

public class Game {
    private int id;
    private String name;
    private Status status;
    private Map<Integer, Integer> moves = new HashMap<>();

    public enum Status {
        IN_PROGRESS ("IN_PROGRESS"),
        PAUSED ("PAUSED"),
        X_WON ("X_WON"),
        O_WON ("O_WON"),
        DRAW ("DRAW");

        private String s;

        Status(String status) {
            this.s = status;
        }

        @Override
        public String toString() {
            return this.s;
        }
    }


    public Game(int id, String name, Status status, Map<Integer, Integer> moves) {
        this.id = id;
        this.name = name;
        this.status = status;
        if (moves != null)
            this.moves = moves;
    }

    public Game(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<Integer, Integer> getMoves() {
        return moves;
    }

    public void setMoves(Map<Integer, Integer> moves) {
        this.moves = moves;
    }
}
