package com.controller;

import com.model.EmailSetup;
import com.service.IEmailSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class EmailSetupController {
    @Autowired
    private IEmailSetupService service;
    @GetMapping("")
    public String showSetup(Model model){
        System.out.println(service.show());
        model.addAttribute("setup", service.show());
        return "index";
    }
    @GetMapping("edit")
    public String edit(Model model){
        model.addAttribute("setup", service.show());
        return "edit";
    }
    @PostMapping("edit")
    public String editConfirm(
            @ModelAttribute EmailSetup emailSetup,
            Model model){
        service.edit(emailSetup);
        model.addAttribute("setup", service.show());
        return "index";
    }
}
