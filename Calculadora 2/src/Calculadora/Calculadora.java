package Calculadora;
import java.util.Scanner;
import java.util.ArrayList;

public class Calculadora {
    private static Scanner escaner = new Scanner(System.in);

    public Calculadora(){}

    public void nuevaOperacion(){
        System.out.println("Ingrese algo");
        String input = escaner.nextLine();
        String[] elementos = input.split(" ");

        if(!validarElementos(elementos)){
            System.out.println("Operacion invalida");
            return;
        }

        double resultado = calcularResultado(elementos);

        System.out.println("El resultado es: " + resultado);
    }

    private boolean validarElementos(String[] elementos){
        if (!elementos[elementos.length - 1].equals("=")) {
            return false;
        }
        for (String elemento : elementos) {
            if (!OperadorValido(elemento) && !esNumero(elemento) && !elemento.equals("=")) {
                return false;
            }
        }
        return true;
    }

    private boolean OperadorValido(String elemento) {
        return elemento.equals("+") || elemento.equals("-") || elemento.equals("*") || elemento.equals("/") || elemento.equals("(") || elemento.equals(")");
    }

    private boolean esNumero(String elemento) {
        try {
            Double.parseDouble(elemento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private double calcularResultado(String[] elementos){
        boolean esBloque = false;
        ArrayList<String> Bloque = new ArrayList<>();
        ArrayList<String> sinBloque = new ArrayList<>();
        int bloquesContados = 0;
        for (int i = 0; i < elementos.length; i++) {
            // 10 + ( 10 * 3 ) =
            // ( 10 + 10 ) * ( 2 + 3 ) =
            // 10 + ( 10 * 2 ) + 10 =
            if(elementos[i].equals("(")){
                System.out.println("inicia un bloque");
                esBloque = true;
            } else if (elementos[i].equals(")")) {
                System.out.println("termina un bloque");
                bloquesContados++;
                esBloque = false;
            } else if (esBloque) {
                System.out.println("Estamos en el bloque");
                Bloque.add(elementos[i]);
            } else if (bloquesContados == 1) {
                double respuesta = calcularResultado(Bloque.toArray(new String[Bloque.size()]));
                sinBloque.add(String.valueOf(respuesta));
                Bloque.clear();
            } else {
                sinBloque.add(elementos[i]);
            }

            // 10 + BLOQUE1 =
            // BLOQUE1 + BLOQUE2 =

            // 10 + ( 10 * 2 ) + 10 =
            // 10 + bloque1 + 10 =
            // 10 + 20 + 10 =
        }

        // return 10.0;
        //return calculoSecuencia(elementos);
        return calculoSecuencia(sinBloque.toArray(new String[sinBloque.size()]));
    }

    private double calculoSecuencia(String[] bloque){
        double resultado = Double.parseDouble(bloque[0]);
        String ultimoOperador = bloque[1];
        for(int i = 2; i < bloque.length; i++){
            if(esNumero(bloque[i])) {
                double numero = Double.parseDouble(bloque[i]);
                switch (ultimoOperador) {
                    case "+":
                        resultado += numero;
                        break;
                    case "-":
                        resultado -= numero;
                        break;
                    case "*":
                        resultado *= numero;
                        break;
                    case "/":
                        resultado /= numero;
                        break;
                    default:
                        resultado = numero;
                        break;
                }
            }else {
                ultimoOperador = bloque[i];
            }
        }
        return resultado;
    }
}
