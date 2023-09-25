package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CursoEntity;
import com.example.demo.repository.CursoRepository;
import com.example.demo.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService{

	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public CursoEntity create(CursoEntity cur) {
		// TODO Auto-generated method stub
		return cursoRepository.save(cur);
	}

	@Override
	public CursoEntity update(CursoEntity cur) {
		// TODO Auto-generated method stub
		return cursoRepository.save(cur);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cursoRepository.deleteById(id);
		
	}

	@Override
	public CursoEntity read(Long id) {
		// TODO Auto-generated method stub
		return cursoRepository.findById(id).get();
	}

	@Override
	public List<CursoEntity> readAll() {
		// TODO Auto-generated method stub
		return cursoRepository.findAll();
	}
	

}
