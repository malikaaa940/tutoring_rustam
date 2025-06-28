package hw;

public abstract class Player {

    private String name;
    private int health;
    private int attackPower;

    public Player(String name, int health, int attackPower ) {

        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public int getHealth() {

        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public void takeDamage(int damage) {
        if(health >= 0) {

            health -= damage;
        }
    }

    public boolean isAlive(){

        return getHealth() > 0;
    }


    public String getName(){
        return name;
    }
}
