package hw;

public class Mage extends Player implements MagicUser{

    public Mage(String name){

        super(name, 70, 30);
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
