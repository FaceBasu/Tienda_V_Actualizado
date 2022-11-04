package com.tienda.service;

import com.tienda.dominio.Articulo;
import java.util.List;


public interface ArticuloService {
    //Los metodos para poder hacer un CRUD
    //Create Read Update Delete
    public List<Articulo> getArticulos(boolean filtro);
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
}
