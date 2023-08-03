package contador.contador;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/mi_server")
public class ContadorController {
    private int contador = 0;

    @GetMapping("")
    public String index(HttpSession sesion){
        if(sesion.getAttribute("contador") == null){
            sesion.setAttribute("contador", 0);
        }

        int contador = (int) sesion.getAttribute("contador") + 1;
        sesion.setAttribute("contador", contador);

        return "index";
    }

    @GetMapping("/contador")
    public String contador(HttpSession sesion, Model modelo){
        int contador = (int) sesion.getAttribute("contador");
        modelo.addAttribute("contador", contador);
        return "contador";
    }

    @GetMapping("/reset")
    public String reset(HttpSession sesion){
        sesion.setAttribute("contador", 0);
        return "reset";
    }
}
