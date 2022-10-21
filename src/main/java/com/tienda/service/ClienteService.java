package com.tienda.service;

import com.tienda.dominio.Cliente;
import java.util.List;


public interface ClienteService {
    //Los metodos para poder hacer un CRUD
    //Create Read Update Delete
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Cliente cliente);
    
    public void save(Cliente cliente);
    
    public void delete(Cliente cliente);
}
