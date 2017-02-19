package com.tictactoe.model;


import java.util.HashMap;
import java.util.Map;

public class Game {
    private int gameId;
    private String gameName;
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


    public Game(int gameId, String gameName, Status status, Map<Integer, Integer> moves) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.status = status;
        if (moves != null)
            this.moves = moves;
    }

    public Game(){}

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
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
