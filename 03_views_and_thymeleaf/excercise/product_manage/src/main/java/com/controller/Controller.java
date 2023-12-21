package com.controller;

import com.model.Product;
import com.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    IService service;
    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("list", service.getAll());
        return "display";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id){
        System.out.println(id);
        service.delete(id);
        return "redirect: /";
    }
    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable int id, Model model){
        model.addAttribute("product", service.detail(id));
        return "edit";
    }
    @GetMapping("create")
    public String showCreateForm(){
        return "create";
    }
    @PostMapping("edit")
    public String edit(@ModelAttribute Product product){
        service.edit(product.getId(), product);
        return "redirect: /";
    }
    @PostMapping("create")
    public String create(@ModelAttribute Product product){
        service.create(product);
        return "redirect: /";
    }
    @GetMapping("detail/{id}")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("product", service.detail(id));
        return "detail";
    }
    @GetMapping("search")
    public String searchForm(){
        return "search";
    }
    @PostMapping("search")
    public String search(@RequestParam String keyword, Model model){
        model.addAttribute("list", service.search(keyword));
        model.addAttribute("input", keyword);
        return "search";
    }
}
