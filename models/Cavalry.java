package models;

public class Cavalry extends Soldier {
    public Cavalry() {
        this.type = "Cavalry";
        this.strength = 20;  // stronger than infantry, for example
        this.cost = 2;       // more expensive to recruit
    }

    @Override
    public void fight() {
        System.out.println("Cavalry charging with strength: " + this.strength);
    }
}