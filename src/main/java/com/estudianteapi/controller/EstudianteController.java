package com.estudianteapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudianteapi.DTO.TemaDTO;
import com.estudianteapi.model.Curso;
import com.estudianteapi.model.Tema;
import com.estudianteapi.service.EstudianteServiceInterface;

@RestController
public class EstudianteController {
    
    @Autowired
    private EstudianteServiceInterface service;

    @PostMapping ("/cursos/crear")
    public void addCurso(@RequestBody Curso curso){
        this.service.addCurso(curso);
    }

    @PostMapping ("/temas/crear")
    public void addTema(@RequestBody TemaDTO temaData){
        this.service.addTema(temaData);
    }

    @GetMapping ("/cursos/traer")
    public List<Curso> getCursos(){
        return this.service.getCursos();
    }

    @GetMapping ("/cursos/buscar")
    public List<Curso> getCursosCon(@RequestParam String nombre){
        return this.service.getCursosCon(nombre);
    }

    @GetMapping ("/temas/traer/{idCurso}")
    public List<Tema> getTemas(@PathVariable Long idCurso){
        return this.service.getTemas(idCurso);
    }

    @PutMapping ("/cursos/editar/{id}")
    public void editCurso(@PathVariable Long id, @RequestBody Curso curso){
        this.service.editCurso(id,curso);
    }

    @PutMapping ("/temas/editar/{id}")
    public void editTema(@PathVariable Long id, @RequestBody TemaDTO tema){
        this.service.editTema(id,tema);
    }
}
