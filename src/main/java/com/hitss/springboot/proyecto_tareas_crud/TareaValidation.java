package com.hitss.springboot.proyecto_tareas_crud;

import com.hitss.springboot.proyecto_tareas_crud.entities.Tarea;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TareaValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Tarea.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Tarea tarea = (Tarea) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"titulo",null,"es requerido");
        if (tarea.getDescripcion() == null || tarea.getDescripcion().isBlank())
            errors.reject("descripcion",null,"es requerido , por favor");
    }

    @Override
    public Errors validateObject(Object target) {
        return Validator.super.validateObject(target);
    }
}
