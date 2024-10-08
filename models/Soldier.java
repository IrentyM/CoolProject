package models;

public abstract class Soldier {
    protected String type;
    protected int strength;
    protected int cost;

    public String getType() {
        return type;
    }

    public int getStrength() {
        return strength;
    }

    public int getCost() {
        return cost;
    }

    public abstract void fight();
}
