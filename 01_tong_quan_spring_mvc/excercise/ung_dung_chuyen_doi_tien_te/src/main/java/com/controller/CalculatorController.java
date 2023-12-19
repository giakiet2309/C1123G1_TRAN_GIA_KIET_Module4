package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("")
    public String createForm() {
        return "index";
    }

    @PostMapping("/result")
    public String changeCurrency(@RequestParam String changeTo,
                                 @RequestParam double currency,
                                 Model model) {
        double result = 0;
        int convert = 24000;
        if ("VND to USD".equals(changeTo)) {
            result = currency / convert;
        } else if ("USD to VND".equals(changeTo)) {
            result = currency * convert;
        }

        model.addAttribute("input", currency);
        model.addAttribute("change", changeTo);
        model.addAttribute("result", result);
        return "index";
    }
}
