package com.hitss.springboot.proyecto_tareas_crud.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tareas")
@NoArgsConstructor
@Getter
@Setter
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 10 , max = 50)
    private String titulo;
    @NotBlank
    @Size(min = 10, max = 50)
    private String descripcion;
    private boolean completada;
}
