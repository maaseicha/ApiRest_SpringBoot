package com.pichincha.backTest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cuenta")
public class Cuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cuenta")
	private long id_cuenta;
	
	@Column(name="num_cuenta")
	private String num_cuenta;
	
	@Column(name="saldo_cuenta")
	private Double saldo_cuenta;
	
	@ManyToOne
	@JoinColumn(name  = "id_usuario")
	private Usuario user;
	
	public Cuenta() {
		super();
	}
	
	public Cuenta(String num_cuenta, Double saldo_cuenta) {
		super();
		this.num_cuenta = num_cuenta;
		this.saldo_cuenta = saldo_cuenta;
	}

	public long getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(long id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public String getNum_cuenta() {
		return num_cuenta;
	}

	public void setNum_cuenta(String num_cuenta) {
		this.num_cuenta = num_cuenta;
	}

	public Double getSaldo_cuenta() {
		return saldo_cuenta;
	}

	public void setSaldo_cuenta(Double saldo_cuenta) {
		this.saldo_cuenta = saldo_cuenta;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
}
