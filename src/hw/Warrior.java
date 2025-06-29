package hw;

public class Warrior extends Player implements Fighter{

    public Warrior(String name) {

        super(name, 70, 70);



    }

    public void attack(Fighter opponent){
        if(opponent.isAlive()){

            opponent.takeDamage(10);
        }
    }

    @Override
    public void takeDamage(int damage) {

        if (getHealth() > 0){

            setHealth(getHealth() * 10 -  damage);
        }

    }


}
