package com.proyectoFinal.controller;

import com.proyectoFinal.domain.Curso;
import lombok.extern.slf4j.Slf4j;
import com.proyectoFinal.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CursoController {
@Autowired
private CursoService cursoService;

 @GetMapping("/curso/listado")
    public String inicio(Model model) {
        var cursos = cursoService.getCursos(false);
        model.addAttribute("cursos",cursos);
        return "/curso/listado";
    }

    @GetMapping("/curso/nuevo")
    public String nuevoCurso(Curso curso) {
        return "/curso/modifica";
    }
    
     @PostMapping("/curso/guardar")
    public String guardarCurso(Curso curso) {
        cursoService.save(curso);
        return "redirect:/curso/listado";
    }
    
    @GetMapping("/curso/modificar/{idCurso}")
    public String modificarCurso(Curso curso, Model model) {
        curso = cursoService.getCurso(curso);
        model.addAttribute("curso",curso);
        return "/curso/modificar";
    }
    
    @GetMapping("/curso/eliminar/{idCurso}")
    public String eliminarCurso(Curso curso) {
        cursoService.delete(curso);
        return "redirect:/curso/listado";
    }
    
}
