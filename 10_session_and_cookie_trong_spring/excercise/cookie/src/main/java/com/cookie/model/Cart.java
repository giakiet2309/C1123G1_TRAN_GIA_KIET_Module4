package com.cookie.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Cart() {
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Boolean checkItemInCart(){
        return products.size() != 0;
    }
    public void addItem(Product product){
        if (products.containsKey(product)){
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }
    public Integer countItem(){
        return products.size();
    }
    public Integer countItemQuantity(){
        int count = 0;
        for (Product product : products.keySet()){
            count += products.get(product);
        }
        return count;
    }
    public Integer totalPayment(){
        int payment = 0;
        for (Product product : products.keySet()){
            payment += product.getPrice() * products.get(product);
        }
        return payment;
    }
}
