package com.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("")
    public String show(){
        return "index";
    }
    @PostMapping("save")
    public String save(
            @RequestParam(value = "Lettuce", required = false, defaultValue = "") String Lettuce,
            @RequestParam(value = "Tomato", required = false, defaultValue = "") String Tomato,
            @RequestParam(value = "Mustard", required = false, defaultValue = "") String Mustard,
            @RequestParam(value = "Sprouts", required = false, defaultValue = "") String Sprouts,
            Model model){


        List<String> resultList = new ArrayList<>();
        if (Lettuce.equals("on")){
            model.addAttribute("Lettuce", "have");
            resultList.add("Lettuce");
        }
        if (Tomato.equals("on")){
            model.addAttribute("Tomato", "have");
            resultList.add("Tomato");
        }
        if (Mustard.equals("on")){
            model.addAttribute("Mustard", "have");
            resultList.add("Mustard");
        }
        if (Sprouts.equals("on")){
            model.addAttribute("Sprouts", "have");
            resultList.add("Sprouts");
        }
        if (resultList.size() == 0){
            model.addAttribute("result", "Chưa lựa chọn gia vị nào");
        } else {
            String result = "Bạn đã chọn sandwich với ";
            for (int i = 0; i < resultList.size(); i++){
                if (i == 0){
                    result += resultList.get(i);
                } else {
                    result += " và " + resultList.get(i);
                }
            }
            model.addAttribute("result", result);
        }
        return "index";

    }
}
