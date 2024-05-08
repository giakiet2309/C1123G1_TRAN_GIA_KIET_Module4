package com.example.thim4p2.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String typeProduct;

    @OneToMany(mappedBy = "typeProduct")
    private Set<Product> products;

    public TypeProduct() {

    }

    public TypeProduct(int id, String typeProduct, Set<Product> products) {
        this.id = id;
        this.typeProduct = typeProduct;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
