package models.AbstractFactory;

public class Castle implements IBuilding {
    private int money;

    public Castle() {
        this.money = 100; // Initial amount
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
