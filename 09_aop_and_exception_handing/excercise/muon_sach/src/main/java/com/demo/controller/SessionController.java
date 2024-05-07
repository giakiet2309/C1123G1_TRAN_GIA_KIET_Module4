package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("password")) {
            session.setAttribute("name", username);
            return "redirect:/";
        } else {
            System.out.println("sai mk");
            return "login";
        }
    }

    @GetMapping("/")
    public String home() {
        String name = (String) session.getAttribute("name");
        if (name != null) {
            return "home";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/login";
    }
}
