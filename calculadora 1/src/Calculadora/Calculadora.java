package Calculadora;
import java.util.Scanner;

public class Calculadora {
    private double num1;
    private double num2;
    private char operador;
    private double resultado = 0.0;
    private static Scanner escaner = new Scanner(System.in);

    public Calculadora(){}

    public void setOperandOne(double num1) {
        this.num1 = num1;
    }
    public void setOperandTwo(double num2) {
        this.num2 = num2;
    }
    public void setOperation(char operador) {
        this.operador = operador;
    }

    public void performOperation() {
        switch (operador) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case'/':
                resultado = num1 / num2;
            default:
                System.out.println("Operación no válida.");
        }
    }

    public double getResult(){
        return resultado;
    }

    public double nuevaOperacion(){
        System.out.println("Elija la operacion que desea realizar: suma (+), resta (-), multiplicacion (*), division (/)");
        this.operador = escaner.nextLine().charAt(0);

        System.out.println("Ingrese el primer numero: ");
        this.num1 = Double.parseDouble(escaner.nextLine());

        System.out.println("Ingrese el segundo numero: ");
        this.num2 = Double.parseDouble(escaner.nextLine());

        performOperation();

        return resultado;
    }
}
