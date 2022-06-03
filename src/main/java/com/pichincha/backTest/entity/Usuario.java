package com.pichincha.backTest.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private long id_usuario;
	
	@Column(name="ci_usuario")
	private String ci_usuario;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@OneToMany(mappedBy= "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Cuenta> cuentas;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String ci_usuario, String nombre, String apellido, Set<Cuenta> cuentas) {
		super();
		this.ci_usuario = ci_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuentas = cuentas;
	}
	
	public Set<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(Set<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getCi_usuario() {
		return ci_usuario;
	}

	public void setCi_usuario(String ci_usuario) {
		this.ci_usuario = ci_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
