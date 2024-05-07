package com.example.thim4p2.service;

import com.example.thim4p2.model.QuocGia;
import com.example.thim4p2.repository.IQuocGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuocGiaService implements IQuocGiaService{
    @Autowired
    IQuocGiaRepository iQuocGiaRepository;
    @Override
    public List<QuocGia> hienThiTatCa() {
        return iQuocGiaRepository.findAll();
    }

    @Override
    public QuocGia layMotQuocGia(int id) {
        return iQuocGiaRepository.findById(id).get();
    }
}
