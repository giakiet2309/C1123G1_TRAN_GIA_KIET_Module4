package com.example.thim4p2.service;

import com.example.thim4p2.model.QuocGia;

import java.util.List;

public interface IQuocGiaService {
    List<QuocGia> hienThiTatCa();
    QuocGia layMotQuocGia(int id);
}
