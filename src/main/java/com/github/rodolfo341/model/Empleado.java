package com.github.rodolfo341.model;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nombre", nullable = false, length = 60)
	private String nombre;

	@Column(name = "apellido", nullable = false, length = 60)
	private String apellido;

	@Column(name = "email", nullable = false, length = 60, unique = true)
	private String email;
	
	public Empleado() {	}

	public Empleado(long id, String nombre, String apellido, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
}
