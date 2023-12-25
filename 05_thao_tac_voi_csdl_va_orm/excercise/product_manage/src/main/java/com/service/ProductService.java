package com.service;

import com.model.Product;
import com.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;
    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public void create(Product product) {
        repository.create(product);
    }

    @Override
    public void edit(int id, Product product) {
        repository.edit(id, product);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Product detail(int id) {
        return repository.detail(id);
    }

    @Override
    public List<Product> search(String keyword) {
        return repository.search(keyword);
    }
}
