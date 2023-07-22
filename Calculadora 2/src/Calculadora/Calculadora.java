package Calculadora;

import java.util.Scanner;

public class Calculadora {
    private static Scanner escaner = new Scanner(System.in);
    private double resultado = 0.0;

    public Calculadora(){}

    public void nuevaOperacion(){
        System.out.println("Ingrese algo");
        String input = escaner.nextLine();
        String[] elementos = input.split(" ");

        if(!validarElementos(elementos)){
            System.out.println("Operacion invalida");
            return;
        }

        calcularResultado(elementos);

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

    private void calcularResultado(String[] elementos){
        for (String termino : elementos) {
            System.out.println(termino);
        }
    }
}
