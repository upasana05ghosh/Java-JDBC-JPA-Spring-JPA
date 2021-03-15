package com.spring.database.database.spring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.database.database.jpa.entity.Person;

public interface PersonSpringJpaRepository extends JpaRepository <Person,Integer>{

}
