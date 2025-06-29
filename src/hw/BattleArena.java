package hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BattleArena {

    public static void main(String[] args) {

        List<Fighter> team1 = new ArrayList<>();
        List<Fighter> team2 = new ArrayList<>();

        Fighter warrior1 = new Warrior("warrior1");
        Fighter warrior2 = new Warrior("warrior2");
        Fighter priest1 = new Priest("priest1");
        Fighter priest2 = new Priest("priest2");
        Fighter rogue1 = new Rogue("rogue1");
        Fighter rogue2 = new Rogue("rogue2");
        Fighter mage1 = new Mage("mage1");
        Fighter mage2 = new Mage("mage2");

        Collections.addAll(team1,warrior1,priest1,rogue1,mage1);
        Collections.addAll(team2,warrior2,priest2,rogue2,mage2);

        BattleArena arena = new BattleArena();
        arena.startBattle(team1, team2);


    }

    boolean teamIsAlive(List<Fighter> team) {
        for (Fighter f : team) {
            if (f.isAlive()) return true;
        }
        return false;
    }


    public void battleLogic(List<Fighter> team1, List<Fighter> team2) {
        Random rand = new Random();
        List<Fighter> aliveOpps = new ArrayList<>();
        for(Fighter fighter2: team2){
            if(fighter2.isAlive()){
                aliveOpps.add(fighter2);
            }
        }


        List<Fighter> allyNeedHealing = new ArrayList<>();
        for(Fighter fighter1: team1){
            if(fighter1.isAlive() && ((Player) fighter1).getHealth() <=5){
                allyNeedHealing.add(fighter1);
            }
        }

        Fighter opponent = aliveOpps.get(rand.nextInt(aliveOpps.size()));
        for(Fighter fighter : team1){
            if(fighter.isAlive() && fighter instanceof Warrior){
                fighter.attack(opponent);
                System.out.println(fighter.getName() + " attacks " + opponent.getName());
            } else if (fighter.isAlive() && fighter instanceof Priest){
                fighter.attack(opponent);
                System.out.println(fighter.getName() + " attacks " + opponent.getName());
                for(Fighter fighter2: allyNeedHealing){
                    ((Priest) fighter).heal(fighter2);
                    System.out.println(fighter.getName() + " healed " + fighter2.getName());
                }

            } else if(fighter.isAlive() && fighter instanceof Rogue){

                fighter.attack(opponent);
                System.out.println(fighter.getName() + " attacks " + opponent.getName());


            } else if (fighter.isAlive() && fighter instanceof Mage){
                ((Mage) fighter).castSpell(opponent);
                System.out.println(fighter.getName() + " casts spell on " + opponent.getName());

            }
        }

    }

    public void startBattle(List<Fighter> team1, List<Fighter> team2) {

        while (teamIsAlive(team1) && teamIsAlive(team2)) {
            battleLogic(team1, team2);


            if (!teamIsAlive(team2)) {
                System.out.println("Team 1 won");
                break;
            }
            battleLogic(team2, team1);

            if (!teamIsAlive(team1)) {
                System.out.println("Team 2 won");
                break;
        }

    }

    }
}
