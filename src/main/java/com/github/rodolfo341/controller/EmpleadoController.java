package com.github.rodolfo341.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.rodolfo341.exceptions.ResourceNotFoundException;
import com.github.rodolfo341.model.Empleado;
import com.github.rodolfo341.repository.IEmpleadoRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoController {
	@Autowired
	private IEmpleadoRepository repository;
	
	@GetMapping("/empleados")
	public List<Empleado> ListAllEmpleados(){
		return repository.findAll();
	}
	
	@PostMapping("/empleados")
	public Empleado saveEmpleado (@RequestBody Empleado empleado) {
		return repository.save(empleado);
	}
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id){
		Empleado empleado = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID: " + id));
		return ResponseEntity.ok(empleado);
	}
	
	@PutMapping("/empleados/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detallesEmpleado){
		Empleado empleado = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID: " + id));
		empleado.setNombre(detallesEmpleado.getNombre());
		empleado.setApellido(detallesEmpleado.getApellido());
		empleado.setEmail(detallesEmpleado.getEmail());
		
		Empleado empleadoActualizado = repository.save(empleado);
		return ResponseEntity.ok(empleadoActualizado);
	}
	
}
