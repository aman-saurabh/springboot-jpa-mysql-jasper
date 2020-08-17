package com.techpassel.springbootjpamysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techpassel.springbootjpamysql.model.BlogPost;

public interface BlogPostRepo extends JpaRepository<BlogPost, Integer>{

}
