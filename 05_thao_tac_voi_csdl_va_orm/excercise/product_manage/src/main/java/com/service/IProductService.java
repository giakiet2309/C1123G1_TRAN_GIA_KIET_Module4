package com.service;

import com.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void create(Product product);
    void edit(int id, Product product);
    void delete(int id);
    Product detail(int id);
    List<Product> search(String keyword);
}
