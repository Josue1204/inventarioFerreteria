package com.prueba.ferre.models.repository;

import com.prueba.ferre.models.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
