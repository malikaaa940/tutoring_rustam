package hw;

public class Priest extends Player implements Healer {

    public Priest(String name) {

        super(name, 100, 0);
    }

    @Override
    public void attack(Fighter opponent) {
        opponent.takeDamage(attackPower);
    }



    public void heal(Fighter ally) {

        if(ally instanceof Player){
            Player ally1 = (Player) ally;

            if(ally1.isAlive()){
                ally1.setHealth(ally1.getHealth() + 50);
                System.out.println(ally1.getName() + "  healed ");
            } else{
                System.out.println(ally1.getName() + "  not healed ");
            }

        }

    }
}
