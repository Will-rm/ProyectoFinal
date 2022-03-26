package com.proyectoFinal.service;

import com.proyectoFinal.dao.CategoriaDao;
import com.proyectoFinal.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    //La implementacion del servicio se conecta con la capa de datos (CategoriaDao)
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>) categoriaDao.findAll();

        if (activos) {
            lista.removeIf(e -> !e.isActivo()); //Remueve todos los inactivos
        }
        
        return lista;
    }

    @Override
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
}
