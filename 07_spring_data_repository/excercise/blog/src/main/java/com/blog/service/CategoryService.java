package com.blog.service;

import com.blog.model.Categories;
import com.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Categories> getAll() {
        return categoryRepository.findAll();
    }
}
