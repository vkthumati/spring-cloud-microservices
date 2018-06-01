package com.spring.restws.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.restws.domain.Post;

@Repository
public interface IPostRepository extends JpaRepository<Post, Integer>{

}
