package com.cookie.controller;

import com.cookie.model.Cart;
import com.cookie.model.Product;
import com.cookie.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public Cart initCart(){
        return new Cart();
    }
    @Autowired
    private IProductService productService;
    @GetMapping("/")
    public String showAll(Model model){
        model.addAttribute("product_list", productService.showAll());
        return "index";
    }
    @GetMapping("/add/{id}")
    public String add(@PathVariable int id,
                      @SessionAttribute(value = "cart", required = false) Cart cart, RedirectAttributes redirectAttributes){

        Product product = productService.getById(id);
        if (product != null){
            redirectAttributes.addFlashAttribute("message",
                    "Vao gio hang thanh cong ! san pham co ten " + product.getName());
            cart.addItem(product);

        }
        return "redirect:/";
    }
    @GetMapping("/cart")
    public String showCart(Model model,
                           @SessionAttribute(value = "cart", required = false) Cart cart){
        model.addAttribute("cart", cart);
        return "cart";
    }
    @GetMapping("/delete/{id}")
    public String deleteItemInCart(@PathVariable int id,
                                   @SessionAttribute(value = "cart", required = false) Cart cart){
        Product product = productService.getById(id);
        cart.getProducts().remove(product);
        return "redirect:/cart";
    }
    @GetMapping("/update/{id}/{value}")
    public String updateCart(@PathVariable int id, @PathVariable int value,
                             @SessionAttribute(value = "cart", required = false) Cart cart){

        Product product = productService.getById(id);
        cart.getProducts().put(product, value);
        return "redirect:/cart";
    }
}
