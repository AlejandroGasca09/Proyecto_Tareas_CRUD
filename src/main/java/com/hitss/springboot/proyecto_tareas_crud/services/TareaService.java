package com.hitss.springboot.proyecto_tareas_crud.services;

import com.hitss.springboot.proyecto_tareas_crud.entities.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaService {
    List<Tarea> findAll();
    Optional<Tarea> findById(Long id);
    Tarea save(Tarea tarea);
    Optional<Tarea> update(Long id,Tarea tarea);
    Optional<Tarea> delete(Long id);
}
