package com.rtwitty.portfolio.controllers;

import com.rtwitty.portfolio.Repositories.InfoRepositoryImpl;
import com.rtwitty.portfolio.models.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class InfoController {

    @Autowired
    private InfoRepositoryImpl repo;

    @RequestMapping("/")
    public String index(Model model){
        List<Info> allInfos = repo.findAll();
        model.addAttribute("infos", allInfos);
        return "index";
    }


}
