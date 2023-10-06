package com.prueba.ferre.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProducto;
    @Column(length = 45,nullable = false,unique = true)
    private String nombre;

    private float precio;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
