package com.blog.service;

import com.blog.model.Blog;
import com.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> showAll() {
        return blogRepository.findAll();
    }

    @Override
    public void editBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(int id) {

        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> search(String name) {
        return null;
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }
}
