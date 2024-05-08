package com.example.thim4p2.service;

import com.example.thim4p2.model.Product;
import com.example.thim4p2.repository.IProduct;
import com.example.thim4p2.repository.ITypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    IProduct iProduct;
    @Autowired
    ITypeProduct iTypeProduct;

    @Override
    public List<Product> listProduct() {
        return iProduct.findAll();
    }

    @Override
    public void addProduct(Product product) {
        iProduct.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        iProduct.deleteById(id);
    }

}
