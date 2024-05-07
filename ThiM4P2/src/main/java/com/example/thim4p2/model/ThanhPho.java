package com.example.thim4p2.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class ThanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String tenThanhPho;
    int dienTich;
    int danSo;
    int GDP;
    @Column(columnDefinition = "0")
    Boolean isDelete;
    @Column(columnDefinition = "text")
    String gioiThieu;
    @ManyToOne()
    @JoinColumn(name = "quoc_gia_id")
    private QuocGia quocGia;

    public ThanhPho() {
    }

    public ThanhPho(int id, String tenThanhPho, int dienTich, int danSo, int GDP, String gioiThieu, QuocGia quocGia) {
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
