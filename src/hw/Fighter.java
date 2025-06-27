package hw;

public interface Fighter {

    public void attack(Fighter opponent);
    public void takeDamage(int damage);
    public boolean isAlive();
    public String getName();
}
