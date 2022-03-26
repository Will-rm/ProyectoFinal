package com.proyectoFinal.controller;

import lombok.extern.slf4j.Slf4j;
import com.proyectoFinal.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
@Autowired
private CursoService cursoService;

 @GetMapping("/")
    public String inicio(Model model) {
        var cursos = cursoService.getCursos(true);
        model.addAttribute("cursos", cursos);
        return "index";
    }
}