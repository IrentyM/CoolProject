package models.AbstractFactory;

public class Farm implements IBuilding {
    private int money;
    private int income;

    public Farm(int money) {
        this.money = money;
        this.income = (int) (money * 0.25);  // 25% от денег — доход
    }

    @Override
    public void addMoneytoBuilding(int amount) {
        money += amount; // Пересчитываем доход при изменении денег
        System.out.println("Farm: Added " + amount + " money. Total: " + money);
    }

    @Override
    public int getIncome() {
        return income;
    }

    public void updateIncome() {
        income = (int) (money * 0.25); // Пересчитываем доход как 25% от текущего количества денег
    }
}

