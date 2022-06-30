package com.estudianteapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudianteapi.DTO.TemaDTO;
import com.estudianteapi.model.Curso;
import com.estudianteapi.model.Tema;
import com.estudianteapi.repository.CursoRepository;
import com.estudianteapi.repository.TemaRepository;

@Service
public class EstudianteService implements EstudianteServiceInterface {
    
    @Autowired
    private CursoRepository cursos;

    @Autowired
    private TemaRepository temas;

    @Override
    public void addCurso(Curso curso) {
        this.cursos.save(curso);
    }

    @Override
    public List<Curso> getCursos() {
        return this.cursos.findAll();
    }

    @Override
    public List<Tema> getTemas(Long idCurso) {
        return this.temas.findAllByCursoId(idCurso);
    }

    @Override
    public Curso getCurso(Long idCurso) {
        return this.cursos.findById(idCurso).get();
    }

    @Override
    public List<Curso> getCursosCon(String buscar){
        return this.cursos.findByNombreContaining(buscar);
    }

    @Override
    public void addTema(TemaDTO data){
        Curso c = this.getCurso(data.getCursoId());
        Tema tema = new Tema(data.getNombre(), data.getDescripcion(), c);
        this.temas.save(tema);
        
    }

    @Override
    public void editCurso(Long id,Curso c) {
        Curso curso = this.cursos.findById(id).orElse(null);
        if (curso != null){
            curso.setNombre(c.getNombre()); curso.setTipo(c.getTipo()); curso.setFin(c.getFin());
            this.cursos.save(curso);
        }

    }

    @Override
    public void editTema(Long id,TemaDTO t) {
        Tema tema = this.temas.findById(id).orElse(null);
        if (tema != null){
            tema.setNombre(t.getNombre()); tema.setDescripcion(t.getDescripcion());
            this.temas.save(tema);
        }
    }
    
}
