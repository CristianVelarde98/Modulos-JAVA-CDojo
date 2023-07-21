package Bank;
import java.util.Random;
import java.util.Scanner;

public class BankAccount {
    private String numeroDeCuenta;
    private double cuentaCorriente = 0.0;
    private double cuentaDeAhorros = 0.0;
    private static int cuentasCreadas = 0;
    private static double SaldoTotal = 0.0;

    private static Scanner escaner = new Scanner(System.in);

    public BankAccount(){
        this.numeroDeCuenta = crearNuemoDeCuenta();
        cuentasCreadas++;
    }

    public String MiCuenta(){
        return numeroDeCuenta;
    }

    private static String crearNuemoDeCuenta(){
        Random numero = new Random();
        StringBuilder aux = new StringBuilder();

        for(int i = 0; i < 10; i++){
            aux.append(numero.nextInt(10));
        }

        return aux.toString();
    }

    public double getCuentaDeAhorros() {
        return cuentaDeAhorros;
    }

    public double getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void depositar(){
        System.out.println("Elija el tipo de cuenta para depositar, debe ser cuenta corriente (CC) o de ahorros (CA)");
        String cuenta = escaner.nextLine();

        System.out.println("Ahora ingrese el monto a depositar: ");
        double monto = Double.parseDouble(escaner.nextLine());

        if("CC".equals(cuenta)){
            this.cuentaCorriente += monto;
            SaldoTotal += monto;
            System.out.println("Operacion realizada con exito");
            System.out.println("Saldo actual de su cuenta corriente es de: " + this.cuentaCorriente);
        } else if("CA".equals(cuenta)){
            this.cuentaDeAhorros += monto;
            SaldoTotal += monto;

            System.out.println("Operacion realizada con exito");
            System.out.println("Saldo actual de su cuenta de ahorros es de: " + this.cuentaDeAhorros);
        }
    }

    public void retirar(){
        System.out.println("Elija el tipo de cuenta para retirar, debe ser cuenta corriente (CC) o de ahorros (CA)");
        String cuenta = escaner.nextLine();

        System.out.println("Ahora ingrese el monto a retirar: ");
        double monto = Double.parseDouble(escaner.nextLine());

        if("CC".equals(cuenta) && this.cuentaCorriente > monto){
            this.cuentaCorriente -= monto;
            SaldoTotal -= monto;
            System.out.println("Operacion realizada con exito");
            System.out.println("Saldo actual de su cuenta corriente es de: " + this.cuentaCorriente);
        } else if("CA".equals(cuenta) && this.cuentaDeAhorros > monto){
            this.cuentaDeAhorros -= monto;
            SaldoTotal -= monto;
            System.out.println("Operacion realizada con exito");
            System.out.println("Saldo actual de su cuenta de ahorros es de: " + this.cuentaDeAhorros);
        }else {
            System.out.println("No tiene suficiente saldo en su cuenta corriente");
        }
    }

    public void verSaldo(){
        System.out.println("Saldo actual de su cuenta de ahorros es de: " + this.cuentaDeAhorros);
        System.out.println("Saldo actual de su cuenta corriente es de: " + this.cuentaCorriente);
    }
}
