package com.pichincha.backTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.backTest.repository.CuentaService;
import com.pichincha.backTest.repository.UsuarioService;

import com.pichincha.backTest.entity.*;
import com.pichincha.backTest.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cuentas/")
public class CuentaController {
	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private UsuarioService userService;
	
	@GetMapping ("listar")
	public List<Cuenta> getCuentas(){
		return this.cuentaService.findAll();
	}
	
	@PostMapping("{id}/save")
	public Cuenta crearCuenta(@PathVariable(value = "id")Long id_usuario, @RequestBody Cuenta cuenta) throws ResourceNotFoundException{
		return userService.findById(id_usuario).map(user->{
			cuenta.setUser(user);
			return cuentaService.save(cuenta);
		}).orElseThrow(()-> new ResourceNotFoundException("No existe el Usuario con el ID: "+id_usuario));
	}
	
}
