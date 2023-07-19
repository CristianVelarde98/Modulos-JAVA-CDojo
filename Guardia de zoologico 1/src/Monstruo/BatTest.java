package Monstruo;

public class BatTest {
    public void testBat() {
        Bat murcielago = new Bat();

        // Atacar la ciudad
        for (int i = 0; i < 3; i++) {
            murcielago.attackTown();
        }
        murcielago.displayEnergy();

        // Comer humanos
        for (int i = 0; i < 2; i++) {
            murcielago.eatHuman();
        }
        murcielago.displayEnergy();


        // Volar dos veces
        for (int i = 0; i < 2; i++) {
            murcielago.fly();
        }
        murcielago.displayEnergy();

    }
}
