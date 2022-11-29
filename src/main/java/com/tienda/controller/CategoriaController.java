package com.tienda.controller;

import com.tienda.dominio.Categoria;
import com.tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    //Provoca que el objeto se cree si no existe o se use el que ya existe... no hace mas de 1 objeto
    //Esto se conoce como inyeccion de dependencias...
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria/listado")
    public String inicio(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        
        var totalCategorias = 0;
        for (var ca : categorias) {
            totalCategorias += ca.idCategoria;
        }
        model.addAttribute("totalCategorias", totalCategorias);
        
        return "/categoria/listado";
    }

    @GetMapping("/categoria/nuevo")
    public String categoriaNuevo(Categoria categoria) {
        return "/categoria/modificar";
    }

    @PostMapping("/categoria/guardar")
    public String categoriaGuardar(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/categoria/modificar/{idCategoria}")
    public String categoriaActualiza(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modificar";

    }

    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String categoriaElimina(Categoria categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";

    }
}
