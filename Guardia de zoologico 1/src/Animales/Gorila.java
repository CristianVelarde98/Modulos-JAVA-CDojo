package Animales;

public class Gorila extends Mamiferos {
    public Gorila() {
        super("Gorila");
    }

    public void throwSomething(){
        System.out.println("El Gorila acaba de lanzar una piedra");
        System.out.println("El Nivel de energia del gorila disminuyo (-5)");
        // this.setEnergy(-5);
        energyLevel += -5;
        System.out.println("Su nivel de energia actual es: " + energyLevel);
    }

    public void eatBananas(){
        // this.setEnergy(10);
        energyLevel += 10;
        System.out.println("El Gorila acaba de comer una banana y su energia aumento (+10)");
        System.out.println("Su nivel de energia actual es: " + energyLevel);
    }

    public void climb(){
        System.out.println("El Gorila acaba de escalar un arbol y su energia disminuyo (-10)");
        // this.setEnergy(-10);
        energyLevel += -10;
        System.out.println("Su nivel de energia actual es: " + energyLevel);
    }
}
