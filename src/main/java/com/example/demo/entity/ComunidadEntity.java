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
@Table(name="COMUNIDAD")
public class ComunidadEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;
	
	@Id
  	@Column(name = "ID_COMUNIDAD")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqConvenio")
    @SequenceGenerator(sequenceName = "SEQ_CONVENIO", allocationSize = 1, name = "seqConvenio")
	private Long id;
  
  	@Column(name = "NOMBRE_COMUNIDAD")
  	private String nombrecomunidad;
  	
  	@Column(name = "AUTORIDAD")
  	private String autoridad;
  
  	@Column(name = "CORREO_AUTORIDAD")
  	private String correo;	

  	@Column(name = "TELEFONO")
  	private int telefono;
  	
  	@Column(name = "IDCONVENIO")
  	private int idconvenio ;
}