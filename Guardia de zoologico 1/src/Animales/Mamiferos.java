package Animales;

public class Mamiferos {
    protected int energyLevel = 100;
    private String nombre = "Animal desconocido";
    public Mamiferos(){}

    public Mamiferos(String nombre){
        this.nombre = nombre;
    }

    public void displayEnergy(){
        System.out.println(energyLevel);
    }

    public int getEnegy(){
        return energyLevel;
    }
    public void setEnergy(int energy){
        this.energyLevel += energy;
    }
}
