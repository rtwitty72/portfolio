package com.rtwitty.portfolio.interfaces;

import com.rtwitty.portfolio.models.Topic;

import java.util.List;


public interface TopicRepository {
    List<Topic> findAll();
    void add(String title, String description);
    void delete(long id);
    }


