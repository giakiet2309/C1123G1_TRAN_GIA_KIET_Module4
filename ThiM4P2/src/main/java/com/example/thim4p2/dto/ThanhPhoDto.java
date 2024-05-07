package com.example.thim4p2.dto;


import com.example.thim4p2.model.QuocGia;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Columns;

public class ThanhPhoDto {
    int id;
    @NotBlank(message = "Không Được Để Trống")
//    @Pattern(regexp = "[a-zA-Z]")
    String tenThanhPho;
    @Min(value = 1,message = "Vui Lòng Nhập Số Nguyên Dương")
    int dienTich;
    @Min(value = 1,message = "Vui Lòng Nhập Số Nguyên Dương")
    int danSo;
    @Min(value = 1,message = "Vui Lòng Nhập Số Nguyên Dương")
    int GDP;
    @NotBlank(message = "Không Được Để Trống")
    String gioiThieu;
    QuocGia quocGia;

    public ThanhPhoDto() {
    }

    public ThanhPhoDto(int id, String tenThanhPho, int dienTich, int danSo, int GDP, String gioiThieu, QuocGia quocGia) {
        this.id = id;
        this.tenThanhPho = tenThanhPho;
        this.dienTich = dienTich;
        this.danSo = danSo;
        this.GDP = GDP;
        this.gioiThieu = gioiThieu;
        this.quocGia = quocGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public int getDanSo() {
        return danSo;
    }

    public void setDanSo(int danSo) {
        this.danSo = danSo;
    }

    public int getGDP() {
        return GDP;
    }

    public void setGDP(int GDP) {
        this.GDP = GDP;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public QuocGia getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(QuocGia quocGia) {
        this.quocGia = quocGia;
    }
}
