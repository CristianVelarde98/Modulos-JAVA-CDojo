package Lookify.Lookify.controladores;

import Lookify.Lookify.modelos.MusicModel;
import Lookify.Lookify.servicios.MusicServices;
import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PresentationDirection;
import java.util.List;

@Controller
public class MusicController {
    private final MusicServices servicios;

    public MusicController(MusicServices servicios) {
        this.servicios = servicios;
    }

    @GetMapping("")
    public String raiz(){
        return "index";
    }

    @GetMapping("/escritorio")
    public String escritorio(Model modelo){
        List<MusicModel> canciones = servicios.traerTodos();
        modelo.addAttribute("canciones", canciones);
        return "escritorio";
    }

    @GetMapping("/buscar")
    public String buscarArtista(@RequestParam("artista") String artista, Model modelo){
        List<MusicModel> canciones = servicios.buscarPorArtista(artista);
        modelo.addAttribute("canciones", canciones);
        modelo.addAttribute("artista", artista);
        if(artista.isBlank()){
            return "redirect:/escritorio";
        }
        return "porArtista";
    }

    @GetMapping("/canciones/nuevo")
    public String nuevaCancion(Model modelo){
        MusicModel song = new MusicModel();
        modelo.addAttribute("cancion", song);
        return "nuevo";
    }

    @PostMapping("/canciones/nuevo")
    public String agregar(@ModelAttribute("cancion") @Valid MusicModel nuevaPista, BindingResult evaluado){
        if(evaluado.hasErrors()){
            return "redirect:/canciones/nuevo";
        } else {
            servicios.crear(nuevaPista);
            return "redirect:/escritorio";
        }
    }

    @DeleteMapping("/canciones/{id}")
    public String eliminarCancion(@PathVariable("id") Long id){
        servicios.eliminarCancion(id);
        return "redirect:/escritorio";
    }

    @GetMapping("/canciones/{id}")
    public String mostrarCancion(@PathVariable("id") Long id, Model modelo){
        MusicModel song = servicios.traerPorId(id);
        if(song != null){
            modelo.addAttribute("cancion", song);
            return "detalle";
        } else {
            return "redirect:/escritorio";
        }
    }

    @GetMapping("/buscar/topDiez")
    public String topDiez(Model modelo){
        List<MusicModel> mejores = servicios.traerTopDiez();
        modelo.addAttribute("canciones", mejores);
        return "topDiez";
    }
}
