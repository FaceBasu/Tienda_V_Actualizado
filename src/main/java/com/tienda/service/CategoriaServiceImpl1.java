package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.dominio.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl1 implements CategoriaService {

    //Provoca que si el objeto ya esta en memoria se usa ese
    //Si no esta en memoria se crea el objeto
    @Autowired
    private CategoriaDao categoriaDao;

    //Los metodos para poder hacer un CRUD
    //Create Read Update Delete
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean filtro) {
        var lista = (List<Categoria>) categoriaDao.findAll();

        if (filtro) { //Si es verdadero solo las categorias activas se deben retornar
            lista.removeIf(e -> !e.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        //Si el idCategoria es 0, lo inserta... si tiene algun valor hace el update de ese registro...
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
}
