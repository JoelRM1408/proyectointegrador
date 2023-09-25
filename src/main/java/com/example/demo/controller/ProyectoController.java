package com.example.demo.controller;

import static com.example.demo.commons.GlobalContants.API_PROYECTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProyectoEntity;
import com.example.demo.service.ProyectoService;

@RestController
@RequestMapping(API_PROYECTO)
public class ProyectoController {
	
	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping("/all")
	public List<ProyectoEntity> listar() {
		return proyectoService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProyectoEntity> listar2(@PathVariable("id") long id) {
		ProyectoEntity proy = proyectoService.read(id);
		if (proy!=null) {
			return new ResponseEntity<>(proy, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Proyecto")
	  public ResponseEntity<ProyectoEntity> createTutorial(@RequestBody ProyectoEntity p) {
	    try {
	    ProyectoEntity proy = proyectoService.create(new ProyectoEntity(p.getId(),p.getNombreproyecto(),p.getTipo(),p.getFechaini(),p.getFechafin(),p.getPoblacion(),p.getZona(),p.getResponsable(),p.getSemestre(),p.getCiclo(),p.getEscuelap(),p.getFacultad(),p.getPresupuesto(),p.getIdcomunidad(),p.getIdcurso()));
	    
	      return new ResponseEntity<>(proy, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	@PutMapping("/proyecto/{id}")
	  public ResponseEntity<ProyectoEntity> updateTutorial(@PathVariable("id") long id, @RequestBody ProyectoEntity p){
		ProyectoEntity proyecto = proyectoService.read(id);

	    if (proyecto!=null) {
	    	proyecto.setId(proyecto.getId());
	    	proyecto.setNombreproyecto(proyecto.getNombreproyecto());
	    	proyecto.setTipo(proyecto.getTipo());
	    	proyecto.setFechaini(proyecto.getFechaini());
	    	proyecto.setFechafin(proyecto.getFechafin());
	    	proyecto.setPoblacion(proyecto.getPoblacion());
	    	proyecto.setZona(proyecto.getZona());
	    	proyecto.setResponsable(proyecto.getResponsable());
	    	proyecto.setSemestre(proyecto.getSemestre());
	    	proyecto.setCiclo(proyecto.getCiclo());
	    	proyecto.setEscuelap(proyecto.getEscuelap());
	    	proyecto.setFacultad(proyecto.getFacultad());
	    	proyecto.setPresupuesto(proyecto.getPresupuesto());
	    	proyecto.setIdcomunidad(proyecto.getIdcomunidad());
	    	proyecto.setIdcurso(proyecto.getIdcurso());
	    	
	    	
	      return new ResponseEntity<>(proyectoService.create(proyecto), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/proyecto/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
	    try {
	    	proyectoService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}