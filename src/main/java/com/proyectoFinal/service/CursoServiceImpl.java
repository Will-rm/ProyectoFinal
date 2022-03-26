package com.proyectoFinal.service;

import com.proyectoFinal.dao.CursoDao;
import com.proyectoFinal.domain.Curso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {

    //La implementacion del servicio se conecta con la capa de datos (CursoDao)
    @Autowired
    private CursoDao cursoDao;

    @Override
    public List<Curso> getCursos(boolean activos) {
        var lista = (List<Curso>) cursoDao.findAll();

        if (activos) {
            lista.removeIf(e -> !e.isActivo()); //Remueve todos los inactivos
        }
        
        return lista;
    }

    @Override
    public void save(Curso curso) {
        cursoDao.save(curso);
    }

    @Override
    public void delete(Curso curso) {
        cursoDao.delete(curso);
    }

    @Override
    public Curso getCurso(Curso curso) {
        return cursoDao.findById(curso.getIdCurso()).orElse(null);
    }
}
