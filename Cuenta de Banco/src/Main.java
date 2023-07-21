import Bank.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount cuentaA = new BankAccount();

        String numero_de_cuenta = cuentaA.MiCuenta();
        System.out.println(numero_de_cuenta);

        cuentaA.verSaldo();

        cuentaA.depositar();
        cuentaA.depositar();

        cuentaA.retirar();
        cuentaA.retirar();

        cuentaA.verSaldo();
        System.out.println(numero_de_cuenta);
    }
}