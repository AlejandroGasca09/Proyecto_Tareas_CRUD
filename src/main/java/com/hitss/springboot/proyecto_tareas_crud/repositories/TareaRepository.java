package com.hitss.springboot.proyecto_tareas_crud.repositories;

import com.hitss.springboot.proyecto_tareas_crud.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea,Long> {

}
