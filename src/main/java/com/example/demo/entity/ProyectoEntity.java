package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PROYECTO")
public class ProyectoEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;
	
	@Id
  	@Column(name = "ID_PROYECTO")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProyecto")
    @SequenceGenerator(sequenceName = "SEQ_PROYECTO", allocationSize = 1, name = "seqProyecto")
	private Long id;
  
  	@Column(name = "NOMBRE_PROYECTO")
  	private String nombreproyecto;
  	
  	@Column(name = "TIPO")
  	private String tipo;
  
  	@Column(name = "FECHA_INI")
  	private String fechaini;

  	@Column(name = "FECHA_TER")
  	private String fechafin;
  	
  	@Column(name = "POBLACION_BENEFICIARIA")
  	private String poblacion ;
  	
  	@Column(name = "ZONA_INTERVENCION")
  	private String zona ;
  	
  	@Column(name = "RESPONSABLE_PROYECTO")
  	private String responsable ;
  	
  	@Column(name = "SEMESTRE")
  	private String semestre;
  
  	@Column(name = "CICLO")
  	private String ciclo;

  	@Column(name = "ESCUELA_PROFESIONAL")
  	private String escuelap;
  	
  	@Column(name = "FACULTAD")
  	private String facultad ;
  	
  	@Column(name = "PRESUPUESTO")
  	private double presupuesto ;
  	
  	@Column(name = "IDCOMUNIDAD")
  	private int idcomunidad ;
  	
  	@Column(name = "IDCURSO")
  	private int idcurso ;

}