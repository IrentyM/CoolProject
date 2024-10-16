package models.AbstractFactory;

import models.AbstractFactory.IBuilding;


public class Market implements IBuilding {
    private int money;

    public Market() {
        this.money = 75;// Initial amount
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
