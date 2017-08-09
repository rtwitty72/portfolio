package com.rtwitty.portfolio.interfaces;

import com.rtwitty.portfolio.models.Info;

import java.util.List;


public interface InfoRepository {
    List<Info> findAll();
    void add(String title, String description);
    void delete(long id);
    }


