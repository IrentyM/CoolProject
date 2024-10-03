package models;

public class Diplomacy implements IDiplomacy {
    private int diplomacyPoints;
    private int opinion;
    private IEconomy economy; // Reference to the Economy class
    private Country country;

    public Diplomacy(int diplomacyPoints, IEconomy economy) {
        this.diplomacyPoints = diplomacyPoints;
        this.opinion = 0; // Default opinion value
        this.economy = economy;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return this.country;
    }

    public boolean canFormAlliance() {
        return diplomacyPoints >= 2 && opinion > 0;
    }

    public boolean canFormNonAggressionPact() {
        return diplomacyPoints >= 1 && opinion > 0;
    }

    public void formAlliance(Country targetCountry) {
        if (canFormAlliance()) {
            diplomacyPoints -= 2;
            opinion += 50; // Increase opinion due to forming an alliance
            System.out.println("Alliance formed with " + targetCountry.getName() + "!");
            // Set relationship status
            targetCountry.getRelationshipManager().setRelationship(this.getCountry(), RelationshipStatus.ALLIED);
            this.getCountry().getRelationshipManager().setRelationship(targetCountry, RelationshipStatus.ALLIED);
        } else {
            System.out.println("Not enough diplomacy points or opinion is too low to form an alliance.");
        }
    }

    public void formNonAggressionPact(Country targetCountry) {
        if (canFormNonAggressionPact()) {
            diplomacyPoints -= 1;
            opinion += 25; // Increase opinion due to forming a pact
            System.out.println("Non-aggression pact formed with " + targetCountry.getName() + "!");
            // Set relationship status
            targetCountry.getRelationshipManager().setRelationship(this.getCountry(), RelationshipStatus.PACT);
            this.getCountry().getRelationshipManager().setRelationship(targetCountry, RelationshipStatus.PACT);
        } else {
            System.out.println("Not enough diplomacy points or opinion is too low to form a non-aggression pact.");
        }
    }

    public void sendGift(Country targetCountry, int amount) {
        if (economy.subtractMoney(amount)) {
            opinion += 10; // Increase opinion with gifts
            System.out.println("Gift of " + amount + " ducats sent to " + targetCountry.getName() + ".");
        }
    }

    public void humiliate(Country targetCountry, int amount) {
        opinion -= 30; // Decrease opinion due to humiliation
        System.out.println("Humiliated " + targetCountry.getName() + ". Opinion decreased.");
    }

    public void breakAlliance(Country targetCountry) {
        targetCountry.getRelationshipManager().setRelationship(this.getCountry(), RelationshipStatus.NEUTRAL);
        this.getCountry().getRelationshipManager().setRelationship(targetCountry, RelationshipStatus.NEUTRAL);
        diplomacyPoints += 2; // Return diplomacy points upon breaking an alliance
        System.out.println("Alliance broken with " + targetCountry.getName() + ".");
    }

    public void declareWar(Country targetCountry) {
        targetCountry.getRelationshipManager().setRelationship(this.getCountry(), RelationshipStatus.AT_WAR);
        this.getCountry().getRelationshipManager().setRelationship(targetCountry, RelationshipStatus.AT_WAR);
        System.out.println("Declared war on " + targetCountry.getName() + "!");
    }
}
