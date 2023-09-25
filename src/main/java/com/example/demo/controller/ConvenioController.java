package com.example.demo.controller;

import static com.example.demo.commons.GlobalContants.API_CONVENIO;

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

import com.example.demo.entity.ConvenioEntity;
import com.example.demo.service.ConvenioService;

@RestController
@RequestMapping(API_CONVENIO)
public class ConvenioController {
	
	@Autowired
	private ConvenioService convenioService;
	
	@GetMapping("/all")
	public List<ConvenioEntity> listar() {
		return convenioService.readAll();
	}

	@GetMapping("buscar/{id}")
	public ResponseEntity<ConvenioEntity> listar2(@PathVariable("id") long id) {
		ConvenioEntity conv = convenioService.read(id);
		if (conv!=null) {
			return new ResponseEntity<>(conv, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/insertarconvenio")
	  public ResponseEntity<ConvenioEntity> createTutorial(@RequestBody ConvenioEntity c) {
	    try {
	    ConvenioEntity conv = convenioService.create(new ConvenioEntity(c.getId(),c.getNombreconvenio(),c.getTipo(),c.getFechaini(),c.getFechafin(),c.getEstado()));
	      return new ResponseEntity<>(conv, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editarconvenio/{id}")
	  public ResponseEntity<ConvenioEntity> updateTutorial(@PathVariable("id") long id, @RequestBody ConvenioEntity c) {
		ConvenioEntity convenio = convenioService.read(id);

	    if (convenio!=null) {
	    	convenio.setId(convenio.getId());
	    	convenio.setNombreconvenio(convenio.getNombreconvenio());
	    	convenio.setTipo(convenio.getTipo());
	    	convenio.setFechaini(convenio.getFechaini());
	    	convenio.setFechafin(convenio.getFechafin());
	    	convenio.setEstado(convenio.getEstado());
	    	
	      return new ResponseEntity<>(convenioService.create(convenio), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/eliminarconvenio/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
	    try {
	    	convenioService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}