package com.fanalca.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fanalca.empleados.models.TipoDocumento;

@Repository
public interface TipoDocumentoRepository  extends JpaRepository<TipoDocumento, Integer>{

}