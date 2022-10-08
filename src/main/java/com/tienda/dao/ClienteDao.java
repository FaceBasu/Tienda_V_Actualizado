
package com.tienda.dao;

import com.tienda.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
    
    
}
