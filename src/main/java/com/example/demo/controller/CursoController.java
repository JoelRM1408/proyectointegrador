package com.example.demo.controller;

import static com.example.demo.commons.GlobalContants.API_CURSO;

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

import com.example.demo.entity.CursoEntity;
import com.example.demo.service.CursoService;

@RestController
@RequestMapping(API_CURSO)
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/all")
	public List<CursoEntity> listar() {
		return cursoService.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CursoEntity> listar2(@PathVariable("id") long id) {
		CursoEntity cur = cursoService.read(id);
		if (cur!=null) {
			return new ResponseEntity<>(cur, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/Curso")
	  public ResponseEntity<CursoEntity> createTutorial(@RequestBody CursoEntity c) {
	    try {
	    CursoEntity conv = cursoService.create(new CursoEntity(c.getId(),c.getNombrecurso(),c.getNombredocente(),c.getSemestre(),c.getCiclo(),c.getEscuelap(),c.getFacultad()));
	      return new ResponseEntity<>(conv, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/curso/{id}")
	  public ResponseEntity<CursoEntity> updateTutorial(@PathVariable("id") long id, @RequestBody CursoEntity c) {
		CursoEntity curso = cursoService.read(id);

	    if (curso!=null) {
	    	curso.setId(curso.getId());
	    	curso.setNombrecurso(curso.getNombrecurso());
	    	curso.setNombredocente(curso.getNombredocente());
	    	curso.setSemestre(curso.getSemestre());
	    	curso.setCiclo(curso.getCiclo());
	    	curso.setEscuelap(curso.getEscuelap());
	    	curso.setFacultad(curso.getFacultad());
	    	
	      return new ResponseEntity<>(cursoService.create(curso), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/curso/{id}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
	    try {
	    	cursoService.delete(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
