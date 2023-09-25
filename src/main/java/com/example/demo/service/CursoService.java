package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.CursoEntity;

public interface CursoService {
	CursoEntity create(CursoEntity conv);
	CursoEntity update(CursoEntity conv);
	void delete(Long id);
	CursoEntity read(Long id);
	List<CursoEntity> readAll();
}
