package models;

public interface IEconomy {
    void calculateIncome();
    boolean subtractMoney(int amount);
    void addMoney(int amount);
    int getMoney();
}