package com.example.thim4p2.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class QuocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String tenQuoc;
    @OneToMany(mappedBy = "quocGia")
    private Set<ThanhPho> thanhPhos;

    public QuocGia() {
    }

    public QuocGia(int id, String tenQuoc, Set<ThanhPho> thanhPhos) {
        this.id = id;
        this.tenQuoc = tenQuoc;
        this.thanhPhos = thanhPhos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenQuoc() {
        return tenQuoc;
    }

    public void setTenQuoc(String tenQuoc) {
        this.tenQuoc = tenQuoc;
    }

    public Set<ThanhPho> getThanhPhos() {
        return thanhPhos;
    }

    public void setThanhPhos(Set<ThanhPho> thanhPhos) {
        this.thanhPhos = thanhPhos;
    }
}
