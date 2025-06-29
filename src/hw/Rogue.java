package hw;

public class Rogue extends Player implements Fighter {

    public Rogue(String name) {
        super(name, 70, 80);
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
