package com.example.thim4p2.service;


import com.example.thim4p2.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {
    List<Product> listProduct();
    void addProduct(Product product);
    void deleteProduct(int id);



}
