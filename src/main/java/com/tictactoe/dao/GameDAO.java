package com.tictactoe.dao;

import com.tictactoe.model.Game;

import java.util.List;
import java.util.Map;


public interface GameDAO {

    int saveGame(Game game);

    void saveMove(int gameId, int fieldNumber);

    List<Game> getAllGames();

    Game findGameById(int id);
    
    Map<Integer, Integer> findMovesInGame(Game game);
    Map<Integer, Integer> findMovesInGame(int gameId);
    

    /*

    boolean gameExists(int gameId);*/
}
