import Calculadora.Calculadora;

public class TestCalculadora {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        System.out.println("Primera operación:");
        calculadora.nuevaOperacion();

        System.out.println("\nSegunda operación:");
        calculadora.nuevaOperacion();

        //System.out.println("\nTercera operación:");
        //calculadora.nuevaOperacion();
    }
}