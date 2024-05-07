package com.example.thim4p2.service;


import com.example.thim4p2.model.ThanhPho;
import com.example.thim4p2.repository.IThanhPhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThanhPhoService implements IThanhPhoService {
    @Autowired
    IThanhPhoRepository iThanhPhoRepository;
    @Override
    public List<ThanhPho> hienThiThanhPho() {
        return iThanhPhoRepository.findAll();
    }

    @Override
    public void luu(ThanhPho thanhPho) {
        iThanhPhoRepository.save(thanhPho);
    }

    @Override
    public void xoaThanhPho(int id) {
        iThanhPhoRepository.deleteById(id);
    }

    @Override
    public ThanhPho chiTiet(int id) {
        return iThanhPhoRepository.findById(id).get();
    }
}
