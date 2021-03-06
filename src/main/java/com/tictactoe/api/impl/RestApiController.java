package com.tictactoe.api.impl;

import com.tictactoe.api.RestApi;
import com.tictactoe.model.Game;
import com.tictactoe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApiController implements RestApi {

    @Autowired
    private GameService gameService;

    @Override
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @Override
    public Game newGame(@RequestBody Game newGame) {
        return gameService.newGame(newGame);
    }
    
    @Override
    public Game getGameById(@PathVariable("id") int id) {
        return gameService.getById(id);
    }
}
