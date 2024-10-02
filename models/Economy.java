package models;

import java.util.List;

public class Economy {
    private int money; // Current amount of money
    private int economicPoints; // Base economic points for income calculation
    private int maintenanceCostPerSoldier; // Maintenance cost per soldier
    private Military military; // Reference to Military class
    private List<Region> regions; // List of regions to calculate region-based income
    private Leader leader; // Reference to leader for economic skill
    private static final int DUCAT_VALUE = 10; // Value of each economic point in ducats
    private static final int BASE_ECONOMIC_POINTS = 3; // Fixed base economic points

    // Constructor
    public Economy(int initialMoney, int economicPoints ) {
        this.money = initialMoney;
        this.maintenanceCostPerSoldier = 1; // Set to 1 ducat per soldier for simplicity
        this.economicPoints  = economicPoints ; // Regions controlled by the country
    }

    // Method to calculate economic points based on regions and leader's skill
    public int calculateEconomicPoints() {
        int totalEconomicPoints = BASE_ECONOMIC_POINTS + leader.getEconomySkill(); // Base + leader's skill
        for (Region region : regions) {
            totalEconomicPoints += region.getDevelopmentLevel(); // Add region development levels
        }
        return totalEconomicPoints;
    }

    // Method to calculate income based on economic points and regions
    public void calculateIncome() {
        int income = calculateEconomicPoints() * DUCAT_VALUE; // Income calculation based on updated economic points
        money += income; // Add income to total money
        System.out.println("Income calculated: " + income + " ducats. Total money: " + money);
    }

    // Method to update economic points (e.g., due to region upgrades)
    public void updateEconomicPoints() {
        this.economicPoints = calculateEconomicPoints(); // Recalculate economic points when regions or leader changes
    }

    // Method to add money (e.g., from gifts, trades, etc.)
    public void addMoney(int amount) {
        money += amount;
        System.out.println(amount + " ducats added. Total money: " + money);
    }

    // Method to subtract money (e.g., for upgrades, spending)
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

    // Method to calculate and deduct maintenance costs for soldiers
    public void deductMaintenanceCosts() {
        int totalMaintenanceCost = military.getSoldiers() * maintenanceCostPerSoldier;
        if (subtractMoney(totalMaintenanceCost)) {
            System.out.println("Maintenance costs deducted: " + totalMaintenanceCost + " ducats");
        } else {
            System.out.println("Not enough money for soldier maintenance! Army might lose soldiers.");
        }
    }

    // Method to recruit soldiers
    public void recruitSoldiers(int numberOfRecruits) {
        int cost = numberOfRecruits; // 1 ducat per recruit
        if (subtractMoney(cost)) {
            military.recruitSoldiers(numberOfRecruits); // Recruit soldiers using Military class
            System.out.println("Recruited " + numberOfRecruits + " soldiers.");
        } else {
            System.out.println("Not enough money to recruit soldiers!");
        }
    }

    // Getters
    public int getMoney() {
        return money;
    }

    public int getEconomicPoints() {
        return economicPoints;
    }

    public Military getMilitary() {
        return military;
    }
}
