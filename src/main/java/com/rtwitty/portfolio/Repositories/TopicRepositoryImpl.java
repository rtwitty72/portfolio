package com.rtwitty.portfolio.Repositories;

import com.rtwitty.portfolio.interfaces.TopicRepository;
import com.rtwitty.portfolio.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TopicRepositoryImpl implements TopicRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Topic> findAll() {
        return jdbcTemplate.query("SELECT * FROM portfolios", new TopicMapper());

    }

    @Override
    public void add(String title, String description){
        jdbcTemplate.update("INSERT INTO portfolios (title, description) VALUES(?, ?)", title, description);

    }

    @Override
    public void delete(long id){
        jdbcTemplate.update("DELETE FROM portfolios WHERE id = ?", id);
    }

    private static class TopicMapper implements RowMapper<Topic>{

        @Override
        public Topic mapRow(ResultSet resultSet, int i) throws SQLException{
            Topic topic = new Topic(resultSet.getInt("id"),
                                    resultSet.getString("title"),
                                    resultSet.getString("description"));
            return topic;
        }

    }


}

