package com.estudianteapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Tema implements Serializable{

    public Tema(){

    }

    public Tema(String nombre, String descripcion, Curso c) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.curso = c;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre, descripcion;

    @ManyToOne
    @JoinColumn(name="CURSO_ID")
    @JsonBackReference
    private Curso curso;
}
