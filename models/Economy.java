package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Economy implements IEconomy {
    private int money; // Current amount of money
    private Map<Country, Integer> moneys;
    private List<IRegion> regions; // List of regions to calculate region-based income
    private ILeader leader; // Reference to leader for economic skill

    private static final int DUCAT_VALUE = 10; // Value of each economic point in ducats
    private static final int BASE_ECONOMIC_POINTS = 3; // Fixed base economic points

    // Constructor
    public Economy(int initialMoney, List<IRegion> regions, ILeader leader) {
        this.money = initialMoney;
        this.moneys = new HashMap<>();
        this.regions = regions;
        this.leader = leader;

    }
    public void setMoney(Country targetCountry, int money ) {
        moneys.put(targetCountry, money);
    }
    public void calculateIncome() {
        int income = calculateEconomicPoints() * DUCAT_VALUE; // Income calculation based on updated economic points
        System.out.println("Income calculated: " + income + " ducats.");
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
    public void spentMoney(int amount) {
        money -= amount;
        System.out.println(amount + " ducats spent. Total money: " + money);
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

    public int getMoney(Country targetCountry) {
        return moneys.getOrDefault(targetCountry, money);
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getTotalWealth() {
        int totalWealth = money; // Start with the money held by this Economy instance
        // Iterate through the map of country money to calculate total wealth
        for (Map.Entry<Country, Integer> entry : moneys.entrySet()) {
            totalWealth += entry.getValue(); // Add each country's wealth
        }
        return totalWealth;
    }
}

