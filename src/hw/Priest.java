package hw;

public class Priest extends Player implements Healer {

    public Priest(String name, int attackPower, int health) {

        super(name, health, attackPower);
    }



    public void heal(Fighter ally) {

    }
}
