package Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
public class MainController {

    @GetMapping("/gold")
    public String raiz(HttpSession session, Model model){
        model.addAttribute("gold", session.getAttribute("gold"));
        return "index";
    }

    @PostMapping("/gold")
    public String enviandoOro(HttpSession sesion, @RequestParam(value="lugar") String lugar){

        System.out.println("pasamos por aca");

        //variable de inicio
        int oro = 0;
        ArrayList<String> resultados = new ArrayList<String>();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("MMMM D Y h:mm a");

        //iniciar clave gold
        if(sesion.getAttribute("gold") == null){
            sesion.setAttribute("gold", oro);
            sesion.setAttribute("resultados", resultados);
        } else {
            oro=(int) sesion.getAttribute("gold");
            resultados = (ArrayList<String>) sesion.getAttribute("resultados");
        }

        // incremento decremento de oro
        if(lugar.equals("farm")){
            int cantidad = new Random().nextInt(11)+10;
            oro += cantidad;
            resultados.add(0, "Entraste a farm y aumentas " + cantidad + " oro " + formatoFecha.format(new Date()));

            sesion.setAttribute("gold", oro);
            sesion.setAttribute("resultados", resultados);
            return "redirect: /gold";
        }


        return "redirect: /gold";
    }
}
