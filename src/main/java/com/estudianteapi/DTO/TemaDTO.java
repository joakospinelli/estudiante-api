package com.estudianteapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class TemaDTO {
    
    private String nombre;
    private String descripcion;
    private Long cursoId;

}
