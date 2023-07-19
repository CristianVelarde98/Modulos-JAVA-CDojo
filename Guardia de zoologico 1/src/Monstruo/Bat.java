package Monstruo;
import Animales.Mamiferos;

public class Bat extends Mamiferos {
    public Bat (){
        super("Murcielago");
        this.setEnergy(300);
    }

    public void fly(){
        System.out.println("El muricielago emieza a volar. *se empieza a escuchar un ruido de aleteo infernal*");
        this.setEnergy(-50);
    }

    public void eatHuman(){
        System.out.println("Bueno, ahi va otro");
        this.setEnergy(25);
    }

    public void attackTown(){
        System.out.println("*se ecuchan estruendos* AHI VIENE!!! CORRAN!!!!");
        this.setEnergy(-100);
    }

}
