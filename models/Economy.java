package models;

public class Economy {
    private int money; // Current amount of money
    private int economicPoints; // Economic points for income calculation
    private int maintenanceCostPerSoldier; // Maintenance cost for soldiers
    private Military military; // Reference to Military class
    private static final int DUCAT_VALUE = 10; // Value of each economic point in ducats

    // Constructor
    public Economy(int initialMoney, int economicPoints) {
        this.money = initialMoney;

        this.maintenanceCostPerSoldier = 1; // Set to 1 ducat per soldier for simplicity
        this.economicPoints = 3; // Base economic points
    }

    // Method to calculate income based on economic points
    public void calculateIncome() {
        int income = economicPoints * DUCAT_VALUE; // Income calculation
        money += income; // Add income to total money
    }

    // Method to update economic points
    public void updateEconomicPoints(int change) {
        economicPoints += change;
    }

    // Method to add money
    public void addMoney(int amount) {
        money += amount;
    }

    // Method to subtract money (e.g., for upgrades, spending)
    public boolean subtractMoney(int amount) {
        if (money >= amount) {
            money -= amount;
            return true; // Successful transaction
        } else {
            System.out.println("Not enough money!");
            return false; // Insufficient funds
        }
    }

    // Method to calculate and deduct maintenance costs for soldiers
    public void deductMaintenanceCosts() {
        int totalMaintenanceCost = military.getSoldiers() * maintenanceCostPerSoldier;
        if (subtractMoney(totalMaintenanceCost)) {
            System.out.println("Maintenance costs deducted: " + totalMaintenanceCost + " ducats");
        }
    }

    // Method to recruit soldiers
    public void recruitSoldiers(int numberOfRecruits) {
        int cost = numberOfRecruits; // 1 ducat per recruit
        if (subtractMoney(cost)) {
            military.recruitSoldiers(numberOfRecruits); // Recruit soldiers using Military class
            System.out.println("Recruited " + numberOfRecruits + " soldiers.");
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
