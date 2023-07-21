import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String,String> trackList = new HashMap<String,String>();

        trackList.put("Macarena","Dale a tu cuerpo alegria macarena, que tu cuerpo es pa darle");
        trackList.put("Feliz Cumpleaños","Que lo cumplas feliz, que lo cumplas feliz");
        trackList.put("Viva la vida","no me se la letra xD");
        trackList.put("La marcha peronista","Los muchachos peronista, todos unidos triunfaremos");

        String titulo = "Feliz Cumpleaños";
        String letra = trackList.get(titulo);

        System.out.println("La letra de la cancion: " + titulo + " es " + letra);
    }
}