package com.github.rodolfo341.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.rodolfo341.model.Empleado;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> { 
	
}
