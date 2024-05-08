package com.example.thim4p2.dto;

import com.example.thim4p2.model.TypeProduct;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ProductDTO {
    int id;
    @Min(value = 5, message = "Tên sản phẩm phải là 5 đến 50 ký tự ")
    @Max(value = 50, message = "Tên sản phẩm phải là 5 đến 50 ký tự ")
    String nameProduct;
//    @Pattern(regexp = "Giá bát đầu phải là số và thấp nhất phải là 100.000 VND")
    int priceProduct;
    @NotBlank(message = " không được để trống")
    String status;
    @NotBlank(message = " không được để trống")
    TypeProduct typeProduct;

    public ProductDTO() {

    }

    public ProductDTO(int id, String nameProduct, int priceProduct, String status, TypeProduct typeProduct) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.status = status;
        this.typeProduct = typeProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }
}
