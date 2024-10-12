package models;

public class EconomicStrategy implements  AIActionStrategy {
    @Override
    public void executeAction(Country country, Game game) {
        System.out.println(country.getName() + " is improving its economy.");
        // Logic for economic improvements (e.g., investing in regions)
        // Example: country.investInRegion(region);
    }
}
