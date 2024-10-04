package models;

import java.util.List;

public class Economy implements IEconomy {
    private int money; // Current amount of money
    private List<IRegion> regions; // List of regions to calculate region-based income
    private ILeader leader; // Reference to leader for economic skill

    private static final int DUCAT_VALUE = 10; // Value of each economic point in ducats
    private static final int BASE_ECONOMIC_POINTS = 3; // Fixed base economic points

    // Constructor
    public Economy(int initialMoney, List<IRegion> regions, ILeader leader) {
        this.money = initialMoney;
        this.regions = regions;
        this.leader = leader;
    }

    public void calculateIncome() {
        int income = calculateEconomicPoints() * DUCAT_VALUE; // Income calculation based on updated economic points
        money += income; // Add income to total money
        System.out.println("Income calculated: " + income + " ducats. Total money: " + money);
    }

    private int calculateEconomicPoints() {
        int totalEconomicPoints = BASE_ECONOMIC_POINTS + leader.getEconomySkill(); // Base + leader's skill
        for (IRegion region : regions) {
            totalEconomicPoints += region.getDevelopmentLevel(); // Add region development levels
        }
        return totalEconomicPoints;
    }

    public void addMoney(int amount) {
        money += amount;
        System.out.println(amount + " ducats added. Total money: " + money);
    }

    public boolean subtractMoney(int amount) {
        if (money >= amount) {
            money -= amount;
            System.out.println(amount + " ducats spent. Total money: " + money);
            return true; // Successful transaction
        } else {
            System.out.println("Not enough money! Current balance: " + money + " ducats.");
            return false; // Insufficient funds
        }
    }

    public int getMoney() {
        return money;
    }
}

