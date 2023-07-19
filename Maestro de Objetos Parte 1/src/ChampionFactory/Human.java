package ChampionFactory;

public class Human {
    private int strength = 3;
    private int intelligence = 3;
    private int stealth = 3;
    private int health = 100;
    private String clase = "Human";
    private String nombre = "Aldeano";
    private boolean vida = true;

    public Human(){}

    public String getClase() {
        return clase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Human(int strength, int intelligence, int stealth, int health, String clase, String nombre){
        this.health = health;
        this.strength = strength;
        this.intelligence = intelligence;
        this.stealth = stealth;
        this.clase = clase;
        this.nombre = nombre;
    }

    public void attack(Human character){
        if(character.vida) {
            System.out.println(this.nombre + " Ah atacado a " + character.nombre);
            System.out.println(character.nombre + " perdio " + this.strength + " puntos de vida");
            character.setHealth(-this.strength);
            isDead(character);
        }
        System.out.println("Ya dejalooo, ya esta muerto!!");
    }

    public void isDead(Human character){
        if(character.health <= 0){
            System.out.println(character.nombre + " Ah Muerto");
            character.vida = false;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength += strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence += intelligence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health += health;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth += stealth;
    }
}
