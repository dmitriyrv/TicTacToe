package com.tictactoe.service.impl;

import com.tictactoe.dao.GameDAO;
import com.tictactoe.model.Game;
import com.tictactoe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDAO gameDAO;

    @Override
    public List<Game> getAllGames() {
        return gameDAO.getAllGames();
    }

    @Override
    public Game newGame(Game newGame) {
        if (newGame == null) {
            newGame = new Game();
        }
        if (newGame.getName() == null) {
            newGame.setName("New Game");
        }
        newGame.setStatus(Game.Status.IN_PROGRESS);
        
        newGame.setId(gameDAO.saveGame(newGame));
        
        return newGame;
    }
    
    @Override
    public Game getById(int id) {
        Game foundGame =  gameDAO.findGameById(id);
        if (foundGame != null && foundGame.getId() != 0){
            foundGame.setMoves(gameDAO.findMovesInGame(id));
        }
        return foundGame;
    }
}
