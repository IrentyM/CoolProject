package models;

public class Infantry extends Soldier {
    public Infantry() {
        this.type = "Infantry";
        this.strength = 10;
        this.cost = 1;
    }

    @Override
    public void fight() {
        System.out.println("Infantry fighting with strength: " + this.strength);
    }
}
