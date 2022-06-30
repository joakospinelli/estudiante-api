package com.estudianteapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudianteapi.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{

    List<Tema> findAllByCursoId(Long c);
    
}
