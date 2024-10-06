package models;

public abstract class Soldier {
    protected String type;
    protected int strength;
    protected int cost; // how much does it cost to recruit this soldier

    public String getType() {
        return type;
    }

    public int getStrength() {
        return strength;
    }

    public int getCost() {
        return cost;
    }

    public abstract void fight(); // Example of a method to represent a soldier in battle
}