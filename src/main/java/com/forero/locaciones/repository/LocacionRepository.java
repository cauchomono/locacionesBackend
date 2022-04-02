package com.forero.locaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forero.locaciones.model.Locacion;

public interface LocacionRepository extends JpaRepository<Locacion, Long>{

}
