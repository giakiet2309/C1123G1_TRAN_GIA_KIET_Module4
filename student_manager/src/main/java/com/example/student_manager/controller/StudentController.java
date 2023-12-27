package com.example.student_manager.controller;

import com.example.student_manager.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService iStudentServicel;


    @GetMapping("")
    public String displayAll(Model model){
     model.addAttribute("students",iStudentServicel.getAll());
        return "home";
    }


}
