package com.proyectoFinal.service;

import com.proyectoFinal.domain.Curso;
import java.util.List;

public interface CursoService {
    public List<Curso> getCursos(boolean activos);
    
    public void save(Curso curso); 
    
    public void delete(Curso curso);
    
    public Curso getCurso(Curso curso);
}
