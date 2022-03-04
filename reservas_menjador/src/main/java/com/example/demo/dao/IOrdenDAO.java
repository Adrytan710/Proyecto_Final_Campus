package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Orden;

public interface IOrdenDAO extends JpaRepository<Orden, Integer>{

}
