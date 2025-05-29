package com.hitss.springboot.proyecto_tareas_crud.services.impl;

import com.hitss.springboot.proyecto_tareas_crud.entities.Tarea;
import com.hitss.springboot.proyecto_tareas_crud.repositories.TareaRepository;
import com.hitss.springboot.proyecto_tareas_crud.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements TareaService {
    @Autowired
    TareaRepository tareaRepository;

    @Override
    public List<Tarea> findAll(){
        return tareaRepository.findAll();
    }

    @Override
    public Optional<Tarea> findById(Long id) {
        return tareaRepository.findById(id);
    }

    @Override
    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Optional<Tarea> update(Long id, Tarea tarea) {
        Optional<Tarea> tareaOptional = tareaRepository.findById(id);
        if (tareaOptional.isPresent()){
            Tarea tareaDB = tareaOptional.get();
            tareaDB.setTitulo(tarea.getTitulo());
            tareaDB.setDescripcion(tarea.getDescripcion());
            tareaDB.setCompletada(tarea.isCompletada());
            return Optional.of(tareaRepository.save(tareaDB));
        }
        return tareaOptional;
    }

    @Override
    public Optional<Tarea> delete(Long id) {
        Optional<Tarea> tareaOptional = tareaRepository.findById(id);
        tareaOptional.ifPresent(tareaRepository::delete);
        return tareaOptional;
    }

}
