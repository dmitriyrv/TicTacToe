package com.tictactoe.dao.impl;

import com.tictactoe.dao.GameDAO;
import com.tictactoe.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameDAOJdbcImpl implements GameDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveGame(Game game) {

        String statement = "INSERT INTO games(game_name, game_status) VALUES (?, ?)";

        KeyHolder holder = new GeneratedKeyHolder();

        return jdbcTemplate.update(statement);

    }

    @Override
    public void saveMove(int gameId, int fieldNumber) {

    }

    @Override
    public List<Game> getAllGames() {
        String statement = "SELECT game_id, game_name, game_status FROM games;";

        List<Game> result = new ArrayList<>();

        jdbcTemplate.query(statement, (rs, rowNum) ->
                new Game(
                        rs.getInt("game_id"),
                        rs.getString("game_name"),
                        Game.Status.valueOf(rs.getString("game_status")),
                        null)).forEach(g -> result.add(g));

        return result;
    }
}
