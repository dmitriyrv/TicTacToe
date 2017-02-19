package com.tictactoe.dao;

import com.tictactoe.model.Game;

import java.util.List;


public interface GameDAO {

    int saveGame(Game game);

    void saveMove(int gameId, int fieldNumber);

    List<Game> getAllGames();

    /*Game getGameById(int gameId);

    boolean gameExists(int gameId);*/
}
