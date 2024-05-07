package com.example.thim4p2.service;


import com.example.thim4p2.model.ThanhPho;

import java.util.List;

public interface IThanhPhoService {
    List<ThanhPho> hienThiThanhPho();
    void luu(ThanhPho thanhPho);
    void xoaThanhPho(int id);
    ThanhPho chiTiet(int id);

}
