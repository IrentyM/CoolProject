package models;

public class DiplomaticStrategy implements  AIActionStrategy {
    @Override
    public void executeAction(Country country, Game game) {
        System.out.println(country.getName() + " is focusing on diplomacy.");
        // Logic for forming alliances or non-aggression pacts
        // Example: country.formAlliance(anotherCountry);
    }
}
