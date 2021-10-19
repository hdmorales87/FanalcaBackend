package com.fanalca.empleados.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fanalca.empleados.models.Empleado;

@Repository
@Transactional
public interface EmpleadoRepository  extends JpaRepository<Empleado, Integer>{

	Optional<Empleado> findById(Long id);

	void deleteById(Long id);

	//Optional<Empleado> findById(Long id);

}