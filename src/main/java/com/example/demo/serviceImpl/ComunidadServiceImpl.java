package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ComunidadEntity;
import com.example.demo.repository.ComunidadRepository;
import com.example.demo.service.ComunidadService;

@Service
public class ComunidadServiceImpl implements ComunidadService{

	
	@Autowired
	private ComunidadRepository comunidadRepository;
	
	@Override
	public ComunidadEntity create(ComunidadEntity post) {
		// TODO Auto-generated method stub
		return comunidadRepository.save(post);
	}

	@Override
	public ComunidadEntity update(ComunidadEntity post) {
		// TODO Auto-generated method stub
		return comunidadRepository.save(post);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		comunidadRepository.deleteById(id);
		
	}

	@Override
	public ComunidadEntity read(Long id) {
		// TODO Auto-generated method stub
		return comunidadRepository.findById(id).get();
	}

	@Override
	public List<ComunidadEntity> readAll() {
		// TODO Auto-generated method stub
		return comunidadRepository.findAll();
	}
	

}