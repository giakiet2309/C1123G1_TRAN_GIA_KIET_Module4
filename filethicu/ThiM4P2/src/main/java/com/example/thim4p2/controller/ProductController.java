package com.example.thim4p2.controller;

import com.example.thim4p2.model.Product;
import com.example.thim4p2.service.IProductService;
import com.example.thim4p2.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @Autowired
    ITypeProductService iTypeProductService;

    @GetMapping("/product")
    private String HomeProduct(Model model) {
        List<Product> product = iProductService.listProduct();
        model.addAttribute("product", product);
        return "home";
    }

    @GetMapping("/xoa")
    private String DeleteProduct(@RequestParam("id") int id, RedirectAttributes redirectAttributes, Model model) {
        iProductService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("msg", 3);
        return "home";
    }
}
