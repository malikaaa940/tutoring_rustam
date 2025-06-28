package hw;

public class Mage extends Player implements MagicUser{

    public Mage(String name, int health, int attackPower){

        super(name, health, attackPower);
    }

    public void castSpell(Fighter opponent) {

        attack(opponent);

    }

    public void attack(Fighter opponent){
        if(opponent.isAlive()){

            opponent.takeDamage(50);
        }
    }




}
