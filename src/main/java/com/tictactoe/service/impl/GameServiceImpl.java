package com.tictactoe.service.impl;

import com.tictactoe.dao.GameDAO;
import com.tictactoe.model.Game;
import com.tictactoe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDAO gameDAO;

    @Override
    public List<Game> getAllGames() {
        return gameDAO.getAllGames();
    }

    @Override
    public int newGame(Game newGame) {
        return gameDAO.saveGame(newGame);
    }
}
