package com.rtwitty.portfolio.controllers;

import com.rtwitty.portfolio.Repositories.TopicRepositoryImpl;
import com.rtwitty.portfolio.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class TopicController {

    @Autowired
    private TopicRepositoryImpl repo;

    @RequestMapping("/")
    public String index(Model model){
        List<Topic> allTopics = repo.findAll();
        model.addAttribute("topics", allTopics);
        return "index";
    }

    @RequestMapping(value = "/createTopic", method = RequestMethod.POST)
    public String createTopic(@RequestParam("title") String title,
                              @RequestParam("description") String description){
        repo.add(title, description);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteTopic", method = RequestMethod.POST)
    public String deleteTopic(@RequestParam("id") long id){
        repo.delete(id);
        return "redirect:/";
    }
}
