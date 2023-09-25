package com.example.demo.controller;

import static com.example.demo.commons.GlobalContants.API_COMUNIDAD;

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

import com.example.demo.entity.ComunidadEntity;
import com.example.demo.service.ComunidadService;

@RestController
@RequestMapping(API_COMUNIDAD)
public class ComunidadController {
	
	@Autowired
	private ComunidadService comunidadService;
	
	@GetMapping("/all")
	public List<ComunidadEntity> listar() {
		return comunidadService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ComunidadEntity> listar2(@PathVariable("id") long id) {
		ComunidadEntity com = comunidadService.read(id);
		if (com!=null) {
			return new ResponseEntity<>(com, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Comunidad")
	  public ResponseEntity<ComunidadEntity> createTutorial(@RequestBody ComunidadEntity c) {
	    try {
	    ComunidadEntity com = comunidadService.create(new ComunidadEntity(c.getId(),c.getNombrecomunidad(),c.getAutoridad(),c.getCorreo(),c.getTelefono(),c.getIdconvenio()));
	      return new ResponseEntity<>(com, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/comunidad/{id}")
	  public ResponseEntity<ComunidadEntity> updateTutorial(@PathVariable("id") long id, @RequestBody ComunidadEntity c) {
		ComunidadEntity comunidad = comunidadService.read(id);

	    if (comunidad!=null) {
	    	comunidad.setId(comunidad.getId());
	    	comunidad.setNombrecomunidad(comunidad.getNombrecomunidad());
	    	comunidad.setAutoridad(comunidad.getAutoridad());
	    	comunidad.setCorreo(comunidad.getCorreo());
	    	comunidad.setTelefono(comunidad.getTelefono());
	    	comunidad.setIdconvenio(comunidad.getIdconvenio());
	    	
	      return new ResponseEntity<>(comunidadService.create(comunidad), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/comunidad/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
	    try {
	    	comunidadService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}