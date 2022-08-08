package com.github.rodolfo341.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.rodolfo341.model.Empleado;
import com.github.rodolfo341.repository.IEmpleadoRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmpleadoController {

	@Autowired
	private IEmpleadoRepository repository;
	
	@GetMapping("/empleados")
	public List<Empleado> ListAllEmpleados(){
		return repository.findAll();
	}
}
