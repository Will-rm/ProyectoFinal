package com.proyectoFinal.service;

import com.proyectoFinal.dao.ClienteDao;
import com.proyectoFinal.dao.CreditoDao;
import com.proyectoFinal.domain.Cliente;
import com.proyectoFinal.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    //La implementacion del servicio se conecta con la capa de datos (ClienteDao)
    @Autowired
    private ClienteDao clienteDao;
    
    @Autowired
    private CreditoDao creditoDao;

    @Override
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();  //se hace insert o update.. en credito
        credito = creditoDao.save(credito);
        cliente.setCredito(credito);
        
        clienteDao.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
}
