package com.pichincha.backTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pichincha.backTest.entity.Cuenta;

@Repository
public interface CuentaService extends JpaRepository<Cuenta, Long>{
	@Query(value = "SELECT * FROM cuenta WHERE id_usuario=?1",nativeQuery=true)
    List<Cuenta> findByIdUsuario(Long id_usuario);
}
