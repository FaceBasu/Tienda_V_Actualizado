package com.tienda.controller;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.String;
import com.tienda.dominio.Cliente;
import com.tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    //Provoca que el objeto se cree si no existe o se use el que ya existe... no hace mas de 1 objeto
    //Esto se conoce como inyeccion de dependencias...
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);

        var limiteTotal = 0;
        for (var c : clientes) {
            limiteTotal += c.credito.limite;
        }
        model.addAttribute("limiteTotal", limiteTotal);
        model.addAttribute("totalClientes", clientes.size());

        return "/cliente/listado";
    }

    @GetMapping("/cliente/busqueda")
    public String clienteBusqueda(Model model) {
        //var clientes = clienteService.getClientesPorApellidos("");
        var clientes = clienteService.getClientesPorApellidos("");
        model.addAttribute("clientes", clientes);
        return "/cliente/busqueda";

    }

    @GetMapping("/cliente/nuevo")
    public String clienteNuevo(Cliente cliente
    ) {
        return "/cliente/modificar";
    }

    @PostMapping("/cliente/guardar")
    public String clienteGuardar(Cliente cliente
    ) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";

    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String clienteActualiza(Cliente cliente, Model model) {

        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";

    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String clienteElimina(Cliente cliente
    ) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }

}
