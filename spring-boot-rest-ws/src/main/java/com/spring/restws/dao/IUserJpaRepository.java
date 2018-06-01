package com.spring.restws.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.restws.domain.User;

@Repository
public interface IUserJpaRepository extends JpaRepository<User, Integer>{

}
