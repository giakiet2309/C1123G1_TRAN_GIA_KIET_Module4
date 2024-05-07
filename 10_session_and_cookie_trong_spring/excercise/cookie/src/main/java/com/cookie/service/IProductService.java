package com.cookie.service;

import com.cookie.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAll();
    Product getById(int id);
}
