package com.estudianteapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudianteapi.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
    
    public List<Curso> findByNombreContaining(String subname);
}
