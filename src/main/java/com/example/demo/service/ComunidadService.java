package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ComunidadEntity;

public interface ComunidadService {
	ComunidadEntity create(ComunidadEntity com);
	ComunidadEntity update(ComunidadEntity com);
	void delete(Long id);
	ComunidadEntity read(Long id);
	List<ComunidadEntity> readAll();
}

