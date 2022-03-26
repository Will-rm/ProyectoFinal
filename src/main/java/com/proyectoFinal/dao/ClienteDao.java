package com.proyectoFinal.dao;

import com.proyectoFinal.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente,Long>{
     
}
