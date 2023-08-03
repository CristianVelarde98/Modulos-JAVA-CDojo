package NinjaGold.NinjaGold;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class NinjaController {
    private static Map<String, int[]> lugares = new HashMap<>();
    private static SimpleDateFormat fecha = new SimpleDateFormat("MMMM d' 'yyyy h:mm a");

    static {
        lugares.put("granja", new int[]{11, 10});
        lugares.put("cueva", new int[]{6, 5});
        lugares.put("casa", new int[]{4, 2});
        lugares.put("casino", new int[]{101, -50});
    }

    @GetMapping("/Gold")
    public String inicio(HttpSession sesion, Model modelo){
        modelo.addAttribute("gold", sesion.getAttribute("gold"));
        modelo.addAttribute("operaciones", sesion.getAttribute("operaciones"));
        return "index";
    }

    @PostMapping("/Gold")
    public String logica(HttpSession sesion, @RequestParam(value="lugar") String lugar){
        // nuestras variables
        int gold = 0;
        ArrayList<String> operaciones = new ArrayList<String>();

        // seteamos las variables
        if(sesion.getAttribute("gold") == null || sesion.getAttribute("operaciones") == null ){
            sesion.setAttribute("gold", gold);
            sesion.setAttribute("operaciones", operaciones);
        }

        int[] nums = lugares.get(lugar);
        agregarGold(lugar, nums[0], nums[1], sesion);

        return "redirect:Gold";
    }

    private void agregarGold(String lugar, int num1, int num2, HttpSession sesion){
        int gold = (int) sesion.getAttribute("gold");
        ArrayList<String> operaciones = (ArrayList<String>) sesion.getAttribute("operaciones");

        int ganancia = new Random().nextInt(num1) + num2;

        gold = gold + ganancia;

        if(ganancia >= 0){
            operaciones.add(0,"Entraste a " + lugar + " y ganaste " + ganancia + " gold " + "( " +fecha.format(new Date()) + " )");
        } else {
            operaciones.add(0,"Entraste a " + lugar + " y perdiste " + ganancia + " gold " + "( " +fecha.format(new Date()) + " )");
        }

        sesion.setAttribute("gold", gold);
        sesion.setAttribute("operaciones", operaciones);
    }

}
