package com.tictactoe.service;


import com.tictactoe.model.Game;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GameService {

    List<Game> getAllGames();

    int newGame(Game newGame);
}
