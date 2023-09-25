package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProyectoEntity;
import com.example.demo.repository.ProyectoRepository;
import com.example.demo.service.ProyectoService;

@Service
public class ProyectoServiceImpl implements ProyectoService{

	
	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Override
	public ProyectoEntity create(ProyectoEntity proy) {
		// TODO Auto-generated method stub
		return proyectoRepository.save(proy);
	}

	@Override
	public ProyectoEntity update(ProyectoEntity conv) {
		// TODO Auto-generated method stub
		return proyectoRepository.save(conv);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		proyectoRepository.deleteById(id);
		
	}

	@Override
	public ProyectoEntity read(Long id) {
		// TODO Auto-generated method stub
		return proyectoRepository.findById(id).get();
	}

	@Override
	public List<ProyectoEntity> readAll() {
		// TODO Auto-generated method stub
		return proyectoRepository.findAll();
	}
	

}