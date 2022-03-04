package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Plato;

public interface IPlatoDAO extends JpaRepository<Plato, Integer>{

}
