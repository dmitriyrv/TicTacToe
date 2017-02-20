package com.tictactoe.service;


import com.tictactoe.model.Game;

import java.util.List;

public interface GameService {

    List<Game> getAllGames();

    Game newGame(Game newGame);
    
    Game getById(int id);
}
