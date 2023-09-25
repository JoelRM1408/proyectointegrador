package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ComunidadEntity;


public interface ComunidadRepository extends JpaRepository<ComunidadEntity, Long>{

}