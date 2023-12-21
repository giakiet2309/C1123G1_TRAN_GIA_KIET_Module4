package com.repository;

import com.model.Product;

import java.util.List;

public interface IRepository {
    List<Product> getAll();
    void create(Product product);
    void edit(int index, Product product);
    void delete(int index);
    Product detail(int index);
    List<Product> search(String keyword);
}
