package com.blog.repository;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where own like :search order by create_date desc ", nativeQuery = true)
    Page<Blog> searchByOwn(@Param("search") String search, Pageable pageable);
}
