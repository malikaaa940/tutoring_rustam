package hw;

public class Rogue extends Player implements Fighter {

    public Rogue(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
    public void attack(Fighter opponent){
        if(opponent.isAlive()){

            opponent.takeDamage(10);
        }
    }



    @Override
    public void takeDamage(int damage) {

        if (getHealth() > 0){

            setHealth(getHealth());

            setHealth(getHealth() -  damage);
        }

    }

}
