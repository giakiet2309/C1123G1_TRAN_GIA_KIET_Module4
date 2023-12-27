package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @GetMapping("/")
    public String displayAll(Model model){
        model.addAttribute("blogList", blogService.showAll());
        return "/display";
    }
    @GetMapping("/create")
    public String showFomrCreate(Model model){
        model.addAttribute("newBlog", new Blog());
        return "/create";
    }
    @PostMapping("create")
    public String createBlog(@ModelAttribute Blog newBlog, Model model){
        blogService.createBlog(newBlog);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model){
        model.addAttribute("editBlog", blogService.findById(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String editBlog(@ModelAttribute Blog editBlog){
        blogService.editBlog(editBlog);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id){
        blogService.deleteBlog(id);
        return "redirect:/";
//        model.addAttribute("blogList", blogService.showAll());
//        return "/display";
    }
}
