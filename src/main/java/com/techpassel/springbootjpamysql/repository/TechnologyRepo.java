package com.techpassel.springbootjpamysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techpassel.springbootjpamysql.model.Technology;

public interface TechnologyRepo extends JpaRepository<Technology, Integer>{

}
