package com.blog.service;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    void createBlog(Blog blog);
//    List<Blog> showAll();
    void editBlog(Blog blog);
    void deleteBlog(int id);
    Page<Blog> search(String name, Pageable pageable);
    Blog findById(int id);

}
