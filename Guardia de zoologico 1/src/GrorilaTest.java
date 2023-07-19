import Animales.Gorila;
import Monstruo.BatTest;

public class GrorilaTest {
    public static void main(String[] args) {
        // Crear una instancia de Gorila
        Gorila gorila = new Gorila();

        // Probar el método displayEnergy()
        gorila.displayEnergy();

        // Probar el método throwSomething()
        gorila.throwSomething();

        // Probar el método eatBananas()
        gorila.eatBananas();

        // Probar el método climb()
        gorila.climb();

        BatTest batTest = new BatTest();
        batTest.testBat();
    }
}