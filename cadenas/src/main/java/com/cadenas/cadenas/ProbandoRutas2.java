package com.cadenas.cadenas;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola")
public class ProbandoRutas2 {

    @RequestMapping("/mundo")
    public String NuevaRuta(){
        return "HOLA MUNDO";
    }

    @RequestMapping("/usuario")
    public String otraRuta(){
        return "HOLA USUARIO";
    }

    @RequestMapping("/buscar")
    public String index(@RequestParam(value="q") String searchQuery) {
        return "Ha buscado:  " + searchQuery;
    }

    @RequestMapping("/m/{track}/{module}/{lesson}")
    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
        return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
    }
}
