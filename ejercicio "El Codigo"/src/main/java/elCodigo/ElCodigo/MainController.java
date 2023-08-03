package elCodigo.ElCodigo;

import jakarta.servlet.http.HttpSession;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private String error = null;

    @GetMapping("/")
    public String inicio(HttpSession sesion, Model modelo){
        modelo.addAttribute("error", error);
        return "index";
    }

    @GetMapping("/code")
    public String code(HttpSession sesion){
        if((boolean) sesion.getAttribute("usuarioValido")){
            return "code";
        } else {
            return "redirect: ";
        }
    }

    @RequestMapping(value = "/loguin", method= RequestMethod.POST)
    public String loguin(@RequestParam(value="codigo") String codigo, HttpSession sesion){
        sesion.setAttribute("usuarioValido", false);

        if(codigo.equals("bushido")){
            sesion.setAttribute("usuarioValido", true);
            error = null;
            return "redirect:code";
        } else {
            error = "Entrena Mas Duro";
            return "redirect: ";
        }
    }
}
