package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Alergia;
import com.example.demo.services.AlergiaServicesImpl;

@RestController
@RequestMapping("/api") // POR DETERMINAR SU USO
public class AlergiaController {

	@Autowired
	AlergiaServicesImpl alergySERV;
	
	@GetMapping("/alergias")
	public List<Alergia> totalRegistros(){
		return alergySERV.totalRegistro();
	}
}
