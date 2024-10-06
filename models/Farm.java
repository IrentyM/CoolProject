package models;


public class Farm implements IBuilding {
    private int money;

    public Farm() {
        this.money = 50;// Initial amount
    }

    @Override
    public void addMoney(int amount) {
        this.money += amount;
    }

    @Override
    public int getIncome() {
        return this.money; // We are returning the current amount of money
    }
}

