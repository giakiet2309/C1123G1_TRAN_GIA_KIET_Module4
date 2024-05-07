package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.IBlogService;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/")
    public String displayAll(Model model,
                             @RequestParam(required = false, defaultValue = "") String search,
                             @RequestParam(required = false, defaultValue = "0") int page){

        Pageable pageable = PageRequest.of(page,3);
        Page<Blog> blogPage = blogService.search(search, pageable);

        model.addAttribute("blogList", blogPage);
        model.addAttribute("search", search);
        return "/display";
    }
    @GetMapping("/create")
    public String showFomrCreate(Model model){
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("newBlog", new Blog());
        return "/create";
    }
    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog newBlog, Model model){
        blogService.createBlog(newBlog);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model){
        model.addAttribute("categories", categoryService.getAll());
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
    }
}
