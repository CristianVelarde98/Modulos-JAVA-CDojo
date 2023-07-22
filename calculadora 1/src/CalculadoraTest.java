import Calculadora.Calculadora;

public class CalculadoraTest {
    public static void main(String[] args) {
        Calculadora calculator = new Calculadora();
        calculator.setOperandOne(10.5);
        calculator.setOperation('+');
        calculator.setOperandTwo(5.2);
        calculator.performOperation();
        double result = calculator.getResult();
        System.out.println("El resultado es: " + result);

        calculator.setOperation('*');
        calculator.performOperation();
        result = calculator.getResult();
        System.out.println("El resultado es: " + result);

        result = calculator.nuevaOperacion();
        System.out.println("El resultado es: " + result);

        result = calculator.nuevaOperacion();
        System.out.println("El resultado es: " + result);

    }
}