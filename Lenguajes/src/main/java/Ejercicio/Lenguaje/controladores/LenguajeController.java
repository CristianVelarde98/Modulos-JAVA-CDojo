package Ejercicio.Lenguaje.controladores;

import Ejercicio.Lenguaje.modelos.Lenguajes;
import Ejercicio.Lenguaje.servicios.LenguajeServ;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/lenguaje")
public class LenguajeController {
    private final LenguajeServ servicios;

    public LenguajeController(LenguajeServ servicios) {
        this.servicios = servicios;
    }

    @GetMapping("")
    public String raiz(Model modelo){
        List<Lenguajes> lenguajes = servicios.traerTodos();
        Lenguajes nuevo = new Lenguajes();

        modelo.addAttribute("lenguajes", lenguajes);
        modelo.addAttribute("lenguaje", nuevo);

        return "index";
    }


    @PostMapping("")
    public String crear(@ModelAttribute("lenguaje") @Valid Lenguajes nuevo, BindingResult evaluado, RedirectAttributes redireccion){
        if(evaluado.hasErrors()){
            return "redirect:/lenguaje";
        } else {
            servicios.crear(nuevo);
            return "redirect:/lenguaje";
        }
    }

    @GetMapping("/{id}")
    public String mostrar(@PathVariable("id") Long id, Model modelo){
        Lenguajes detalle = servicios.traerLenguaje(id);
        if(detalle != null){
            modelo.addAttribute("lenguaje", detalle);
            return "show";
        } else {
            return "paginaError";
        }
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable("id") Long id, Model modelo){
        Lenguajes lenguaje = servicios.traerLenguaje(id);
        modelo.addAttribute("lenguaje", lenguaje);
        return "edit";
    }

    @PutMapping("/actualizar")
    public String editar(@Valid Lenguajes editado, BindingResult evaluado){
        if(evaluado.hasErrors()){
            return "redirect:/lenguaje/" + editado.getId() + "/editar";
        } else {
            servicios.editarLenguaje(editado);
            return "redirect:/lenguaje/" + editado.getId();
        }
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable("id") Long id){
        Lenguajes lenguaje = servicios.traerLenguaje(id);
        if(lenguaje == null){
            return "redirect:/lenguaje/" + id;
        } else {
            servicios.eliminarLenguaje(id);
            return "redirect:/lenguaje";
        }
    }

}
