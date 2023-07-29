package Mostrar.La.Fecha;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {

    @GetMapping("/")
    public String inicio(){
        return "index";
    }

    @GetMapping("/date")
    public String date(Model model){
        SimpleDateFormat formato = new SimpleDateFormat("EEEE, W 'de' MMMM, yyyy ");
        String fecha = formato.format(new Date());
        model.addAttribute("fecha", fecha);
        return "date";
    }

    @GetMapping("/time")
    public String time(Model model){
        SimpleDateFormat formato = new SimpleDateFormat("h':'m a");
        String hora = formato.format(new Date());
        model.addAttribute("hora", hora);
        System.out.println(hora);
        return "time";
    }
}
