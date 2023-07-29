package com.holaHumano.hola.humano;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class saludoController {

    @RequestMapping("/hola")
    public String holaHumano(@RequestParam(value="name") String nombre){
        System.out.println("llego una peticion");
        if(nombre != null){
            return "Hola " + nombre;
        } else {
            return "Hola Humano";
        }
    }

}
