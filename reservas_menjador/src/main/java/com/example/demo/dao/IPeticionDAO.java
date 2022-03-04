package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Peticion;

public interface IPeticionDAO extends JpaRepository<Peticion, Integer>{

}
