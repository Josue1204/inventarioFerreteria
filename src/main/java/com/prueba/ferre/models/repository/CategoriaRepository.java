package com.prueba.ferre.models.repository;

import com.prueba.ferre.models.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
