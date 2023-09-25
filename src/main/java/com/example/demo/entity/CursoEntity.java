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
@Table(name="CURSO")
public class CursoEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;
	
	@Id
  	@Column(name = "ID_CURSO")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCurso")
    @SequenceGenerator(sequenceName = "SEQ_CURSO", allocationSize = 1, name = "seqCurso")
	private Long id;
  
  	@Column(name = "NOMBRE_CURSO")
  	private String nombrecurso;
  	
  	@Column(name = "NOMBRE_DOCENTE")
  	private String nombredocente;
  	
  	@Column(name = "SEMESTRE")
  	private String semestre;
  
  	@Column(name = "CICLO")
  	private String ciclo;

  	@Column(name = "ESCUELA_PROFESIONAL")
  	private String escuelap;
  	
  	@Column(name = "FACULTAD")
  	private String facultad ;

}
