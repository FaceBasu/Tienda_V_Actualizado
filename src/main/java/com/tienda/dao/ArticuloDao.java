
package com.tienda.dao;

import com.tienda.dominio.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloDao extends JpaRepository<Articulo, Long> {
    
    
}
