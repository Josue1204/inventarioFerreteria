package com.prueba.ferre.controller;


import com.prueba.ferre.models.entity.Categoria;
import com.prueba.ferre.models.entity.Producto;
import com.prueba.ferre.models.repository.CategoriaRepository;
import com.prueba.ferre.models.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @GetMapping("/productos/nuevo")
    public String mostrarFormularioNuevo(Model model){
        List<Categoria>listaCategorias=categoriaRepository.findAll();

        model.addAttribute("producto",new Producto());
        model.addAttribute("listaCategorias",listaCategorias);
                return "producto_formulario";
    }
    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto){
        productoRepository.save(producto);
        return "redirect:/";
    }
    @GetMapping("/productos")
            public String litarProductos(Model model){
        List<Producto>listaProductos=productoRepository.findAll();
        model.addAttribute("listaProductos",listaProductos);
        return "productos";
    }
    @GetMapping("productos/edita/{id}")
    public String mostrarFormularioEditar(@PathVariable("id")Long id,Model modelo){
        Producto producto=productoRepository.findById(id).get();
        modelo.addAttribute("producto",producto);

        List<Categoria>listaCategorias=categoriaRepository.findAll();
        modelo.addAttribute("listaCategorias",listaCategorias);
        return "producto_formulario";
    }
@GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id")Long id, Model modelo){
        productoRepository.deleteById(id);
        return "redirect:/productos";
}
}

