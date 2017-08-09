package com.rtwitty.portfolio.Repositories;

import com.rtwitty.portfolio.interfaces.InfoRepository;
import com.rtwitty.portfolio.models.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InfoRepositoryImpl implements InfoRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Info> findAll() {
        return jdbcTemplate.query("SELECT * FROM portfolios", new InfoMapper());

    }

    @Override
    public void add(String title, String description){
        jdbcTemplate.update("INSERT INTO portfolios (title, description) VALUES(?, ?)", title, description);

    }

    @Override
    public void delete(long id){ jdbcTemplate.update("DELETE FROM portfolios WHERE id = ?", id);
    }

    private static class InfoMapper implements RowMapper<Info>{

        @Override
        public Info mapRow(ResultSet resultSet, int i) throws SQLException{
            Info info = new Info(resultSet.getInt("id"),
                                    resultSet.getString("title"),
                                    resultSet.getString("description"));
            return info;
        }

    }


}

