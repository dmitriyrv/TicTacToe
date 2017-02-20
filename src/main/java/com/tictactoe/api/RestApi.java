package com.tictactoe.api;

import com.tictactoe.model.Game;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tictactoe/api")
public interface RestApi {

    @RequestMapping(method = RequestMethod.GET, value = "games/all")
    List<Game> getAllGames();

    @RequestMapping(method = RequestMethod.POST, value = "games/new")
    Game newGame(Game newGame);
    
    @RequestMapping(method = RequestMethod.GET, value = "games/game/{id}")
    Game getGameById(int id);

}
