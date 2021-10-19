package com.fanalca.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fanalca.empleados.models.Area;

@Repository
public interface AreaRepository  extends JpaRepository<Area, Integer>{

}