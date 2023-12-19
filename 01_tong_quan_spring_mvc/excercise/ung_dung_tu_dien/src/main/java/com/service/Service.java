package com.service;

import com.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service implements IService{
    @Autowired
    private IRepository repository;
    public String translate(String word){
        return repository.translate(word);
    }
}
