package com.tictactoe.api;

import com.tictactoe.model.Game;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/tictactoe/api")
public interface RestApi {

    @RequestMapping(method = RequestMethod.GET, value = "games/all")
    List<Game> getAllGames();

    @RequestMapping(method = RequestMethod.POST, value = "games/new")
    int newGame(Game newGame);

}
