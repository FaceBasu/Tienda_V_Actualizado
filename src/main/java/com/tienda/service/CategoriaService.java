package com.tienda.service;

import com.tienda.dominio.Categoria;
import java.util.List;


public interface CategoriaService {
    //Los metodos para poder hacer un CRUD
    //Create Read Update Delete
    public List<Categoria> getCategorias(boolean filtro);
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);
}
