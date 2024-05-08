package com.example.thim4p2.service;

import com.example.thim4p2.model.TypeProduct;
import com.example.thim4p2.repository.IProduct;
import com.example.thim4p2.repository.ITypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService implements ITypeProductService {
    @Autowired
    IProduct iProduct;
    @Autowired
    ITypeProduct iTypeProduct;

    @Override
    public List<TypeProduct> listTypeProduct() {
        return iTypeProduct.findAll();
    }
}
