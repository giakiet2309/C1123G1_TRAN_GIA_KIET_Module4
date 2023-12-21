package com.service;

import com.model.Product;
import com.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class Service implements IService{
    @Autowired
    IRepository repository;
    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public void create(Product product) {
        repository.create(product);
    }

    @Override
    public void edit(int index, Product product) {
        repository.edit(index, product);
    }

    @Override
    public void delete(int index) {
        repository.delete(index);
    }

    @Override
    public Product detail(int index) {
        return repository.detail(index);
    }

    @Override
    public List<Product> search(String keyword) {
        return repository.search(keyword);
    }
}
