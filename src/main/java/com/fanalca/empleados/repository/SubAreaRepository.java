package com.fanalca.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fanalca.empleados.models.SubArea;

@Repository
public interface SubAreaRepository  extends JpaRepository<SubArea, Integer>{

}
