package com.tictactoe.dao.impl;

import com.tictactoe.dao.GameDAO;
import com.tictactoe.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GameDAOJdbcImpl implements GameDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveGame(Game game) {

        String statement = "INSERT INTO games(game_name, game_status) VALUES (?, ?)";

        KeyHolder holder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = (con -> {
            PreparedStatement ps = con.prepareStatement(statement, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, game.getName());
            ps.setString(2,game.getStatus().toString());
            return ps;
        });
    
        jdbcTemplate.update(psc, holder);
        
        return (Integer) holder.getKeys().get("game_id");
    
    }

    @Override
    public void saveMove(int gameId, int fieldNumber) {
        String maxMoveNumberQuery = "SELECT MAX(move_no) last_no FROM moves WHERE game_id = ?";
        int nextMoveNumber = jdbcTemplate.query(maxMoveNumberQuery, new Object[]{gameId},
                (rs, rowNum) -> rs.getInt(1))
                .get(0) + 1;
    
        String stmt = "INSERT INTO moves(game_id, move_no, field_no) VALUES (?, ?, ?)";
        PreparedStatementCreator psc = (con -> {
            PreparedStatement ps = con.prepareStatement(stmt);
            ps.setInt(1, gameId);
            ps.setInt(2, nextMoveNumber);
            ps.setInt(3, fieldNumber);
            return ps;
        });
        
        jdbcTemplate.update(psc);
    }

    @Override
    public List<Game> getAllGames() {
        String statement = "SELECT game_id, game_name, game_status FROM games";

        List<Game> result = new ArrayList<>();

        jdbcTemplate.query(statement, (rs, rowNum) ->
                new Game(
                        rs.getInt("game_id"),
                        rs.getString("game_name"),
                        Game.Status.valueOf(rs.getString("game_status")),
                        null)).forEach(g -> result.add(g));

        return result;
    }
    
    @Override
    public Game findGameById(int id) {
        String statement = "SELECT game_id, game_name, game_status FROM games WHERE game_id = ?";
        Game foundGame =  jdbcTemplate.query(statement, new Object[]{id},
                (rs, rowNum) -> new Game(
                        rs.getInt("game_id"),
                        rs.getString("game_name"),
                        Game.Status.valueOf(rs.getString("game_status")),
                        null)
                ).get(0);
        return foundGame != null ? foundGame : new Game();
    }
    
    @Override
    public Map<Integer, Integer> findMovesInGame(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("NULL argument provided");
        }
        return  findMovesInGame(game.getId());
    }
    
    @Override
    public Map<Integer, Integer> findMovesInGame(int gameId) {
        String stmt = "SELECT move_no, field_no FROM moves WHERE game_id = ? ORDER BY move_no";
        Map<Integer,Integer> moves = new HashMap<>();
        
        jdbcTemplate.query(stmt, new Object[]{gameId},
                ((rs, rowNum) -> moves.put(rs.getInt(1), rs.getInt(2)))
        );
        
        
        return moves;
    }
}
