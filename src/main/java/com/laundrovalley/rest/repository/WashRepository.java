package com.laundrovalley.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundrovalley.rest.model.Wash;

public interface WashRepository extends JpaRepository<Wash, Integer>{

}
