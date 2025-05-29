package com.hitss.springboot.proyecto_tareas_crud.controllers;

import com.hitss.springboot.proyecto_tareas_crud.entities.Tarea;
import com.hitss.springboot.proyecto_tareas_crud.services.TareaService;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<Tarea> list(){
        return tareaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Tarea> tareaOptional = tareaService.findById(id);
        if (tareaOptional.isPresent())
            return ResponseEntity.ok(tareaOptional.orElseThrow());
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Tarea tarea, BindingResult result){
        if (result.hasFieldErrors())
            return validation(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaService.save(tarea));

    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String , String> errors = new HashMap<>();
    }


}
