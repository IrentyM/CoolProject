package models;

public class AggressiveStrategy implements  AIActionStrategy {
    @Override
    public void executeAction(Country country, Game game) {
        System.out.println(country.getName() + " is taking aggressive actions.");
        // Logic for aggressive military actions (e.g., attacking nearby enemies)
        // Example: country.attack(nearestEnemy);
    }
}


