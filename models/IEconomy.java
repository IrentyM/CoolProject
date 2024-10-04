package models;

public interface IEconomy {
    void calculateIncome();
    boolean subtractMoney(int amount);
    void addMoney(int amount);
    int getMoney(Country targetCountry) ;
    void setMoney(Country country, int money );
    void spentMoney(int amount);
}