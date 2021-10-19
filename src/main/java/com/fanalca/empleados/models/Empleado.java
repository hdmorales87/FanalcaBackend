package com.fanalca.empleados.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name = "empleados")
public class Empleado implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long documento;
	private String nombres;
	private String apellidos;
	private int edad;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_documento")
	private TipoDocumento tipo_documento;
	@ManyToOne
	@JoinColumn(name="id_area")
	private Area area;
	@ManyToOne
	@JoinColumn(name="id_subarea")
	private SubArea subarea;
}
