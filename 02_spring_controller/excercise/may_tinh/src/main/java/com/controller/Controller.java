package com.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("")
    public String show(){
        return "index";
    }
    @PostMapping("calculator")
    public String calculation(
            @RequestParam double number1,
            @RequestParam double number2,
            @RequestParam int action,
            Model model){



        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        double result = 0;
        switch (action){
            case 1:
                result = number1 + number2;
                model.addAttribute("result", "Kết quả : " + result);
                break;
            case 2:
                result = number1 - number2;
                model.addAttribute("result", "Kết quả : " + result);
                break;
            case 3:
                result = number1 * number2;
                model.addAttribute("result", "Kết quả : " + result);
                break;
            case 4:
                if (number2 == 0){
                    model.addAttribute("result", "Không thể chia cho 0");
                } else {
                    result = number1 / number2;
                    model.addAttribute("result", "Kết quả : " + result);
                }
                break;
        }

        return "index";
    }
}
