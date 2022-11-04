package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.dominio.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    //Provoca que si el objeto ya esta en memoria se usa ese
    //Si no esta en memoria se crea el objeto
    @Autowired
    private ArticuloDao articuloDao;

    //Los metodos para poder hacer un CRUD
    //Create Read Update Delete
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean filtro) {
        var lista = (List<Articulo>) articuloDao.findAll();

        if (filtro) { //Si es verdadero solo las articulos activos se deben retornar
            lista.removeIf(e -> !e.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        //Si el idArticulo es 0, lo inserta... si tiene algun valor hace el update de ese registro...
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }
}
