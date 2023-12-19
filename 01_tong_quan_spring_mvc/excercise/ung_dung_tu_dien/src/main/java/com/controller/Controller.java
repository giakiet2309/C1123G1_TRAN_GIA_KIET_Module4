package com.controller;

import com.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private IService service;
    @GetMapping("")
    public String showForm(){
        return "index";
    }
    @PostMapping("/mainpage")
    public String translate(@RequestParam String word, Model model){
        String result = service.translate(word);
        model.addAttribute("input", word);
        model.addAttribute("result", result);
        return "index";
    }
}
