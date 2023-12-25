package com.controller;

import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("list", productService.getAll());
        return "display";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id){
        System.out.println(id);
        productService.delete(id);
        return "redirect: /";
    }
    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable int id, Model model){
        model.addAttribute("product", productService.detail(id));
        return "edit";
    }
    @GetMapping("create")
    public String showCreateForm(){
        return "create";
    }
    @PostMapping("edit")
    public String edit(@ModelAttribute Product product){
        productService.edit(product.getId(), product);
        return "redirect: /";
    }
    @PostMapping("create")
    public String create(@ModelAttribute Product product){
        productService.create(product);
        return "redirect: /";
    }
    @GetMapping("detail/{id}")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("product", productService.detail(id));
        return "detail";
    }
    @GetMapping("search")
    public String searchForm(){
        return "search";
    }
    @PostMapping("search")
    public String search(@RequestParam String keyword, Model model){
        model.addAttribute("list", productService.search(keyword));
        model.addAttribute("input", keyword);
        return "search";
    }
}
