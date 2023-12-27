package com.blog.service;

import com.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    void createBlog(Blog blog);
    List<Blog> showAll();
    void editBlog(Blog blog);
    void deleteBlog(int id);
    List<Blog> search(String name);
    Blog findById(int id);

}
