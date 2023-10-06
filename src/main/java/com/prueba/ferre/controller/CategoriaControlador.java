package com.prueba.ferre.controller;

import com.prueba.ferre.models.entity.Categoria;
import com.prueba.ferre.models.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoriaControlador {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @GetMapping("/categorias")
    public String listarCategoria(Model model){
        List<Categoria>listaCategorias=categoriaRepository.findAll();
        model.addAttribute("listaCategorias",listaCategorias);
        return "categorias";
    }
    @GetMapping("/categorias/nuevo")
    public  String mostrarFormularioNuevaCategoria(Model model){
        model.addAttribute("catehoria",new Categoria());
        return "categoria_formulario";
    }
@PostMapping("/categorias/guardar")
    public String guardarCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
}

}
