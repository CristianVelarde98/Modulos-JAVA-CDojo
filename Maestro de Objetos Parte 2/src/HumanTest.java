import ChampionFactory.Ninja.Ninja;
import ChampionFactory.Samurai.Samurai;
import ChampionFactory.Wizard.Wizard;

public class HumanTest {
    public static void main(String[] args) {
        Ninja Ninja1 = new Ninja("Esteban");

        Samurai Samurai1 = new Samurai("Samurai Jack");
        Samurai Samurai2 = new Samurai("Yoda");
        Samurai Samurai3 = new Samurai("Pele");

        Wizard Wizard1 = new Wizard("Matilda");
        Wizard Wizard2 = new Wizard("Manolo");

        for(int i = 0; i <= 100; i++){
            Samurai1.attack(Wizard2);
        }
        int min = Integer.MIN_VALUE;
    }
}