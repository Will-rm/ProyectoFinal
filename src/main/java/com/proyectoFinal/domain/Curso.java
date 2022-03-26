package com.proyectoFinal.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "curso")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;
    private Long idCategoria;
    private String detalle;
    private double precio;
    private int cupos;
    private boolean activo;

    public Curso() {
    }

    public Curso(Long idCategoria, String detalle, double precio, int cupos, boolean activo) {
        this.idCategoria = idCategoria;
        this.detalle = detalle;
        this.precio = precio;
        this.cupos = cupos;
        this.activo = activo;
    }

}
