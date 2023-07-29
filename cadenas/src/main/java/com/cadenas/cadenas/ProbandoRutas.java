package com.cadenas.cadenas;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProbandoRutas {
    @RequestMapping("/")
    public String hola(){
        return "Saludos Cliente, como te encuentras el dia de hoy ?";
    }

    @RequestMapping("/random3")
    public String mensajePositivo(){
        return "Me encanta Springboot para hacer rest apt!!!";
    }


}
