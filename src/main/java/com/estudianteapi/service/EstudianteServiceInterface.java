package com.estudianteapi.service;

import java.util.List;

import com.estudianteapi.DTO.TemaDTO;
import com.estudianteapi.model.Curso;
import com.estudianteapi.model.Tema;

public interface EstudianteServiceInterface {

    public void addCurso(Curso curso);
    public void addTema(TemaDTO data);
    public void editCurso(Long id, Curso curso);
    public void editTema(Long id,TemaDTO tema);
    public List<Curso> getCursos();
    public List<Curso> getCursosCon(String buscar);
    public List<Tema> getTemas(Long idCurso);
    public Curso getCurso(Long idCurso);
    
}
