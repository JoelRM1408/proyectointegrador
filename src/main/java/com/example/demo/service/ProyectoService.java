package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.ProyectoEntity;

public interface ProyectoService {
	ProyectoEntity create(ProyectoEntity proy);
	ProyectoEntity update(ProyectoEntity proy);
	void delete(Long id);
	ProyectoEntity read(Long id);
	List<ProyectoEntity> readAll();
}
