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
    public int getOpinion() {
        return opinion;
    }
    public Country getCountry(Country targetCountry) {
        return targetCountry;
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
            targetCountry.getRelationshipManager().setRelationship(this.getCountry(targetCountry), RelationshipStatus.ALLIED);
            this.getCountry( targetCountry).getRelationshipManager().setRelationship(targetCountry, RelationshipStatus.ALLIED);
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
            targetCountry.getRelationshipManager().setRelationship(this.getCountry(targetCountry), RelationshipStatus.PACT);
            this.getCountry(targetCountry).getRelationshipManager().setRelationship(targetCountry, RelationshipStatus.PACT);
        } else {
            System.out.println("Not enough diplomacy points or opinion is too low to form a non-aggression pact.");
        }
    }

    public void sendGift(Country targetCountry, int amount) {
        // Check if there is enough money to send the gift
        if (economy.subtractMoney(amount)) {
            int opinionIncrease = amount / 10; // Each 10 ducats increases opinion by 1
            opinion += opinionIncrease;
            System.out.println("Gift sent to " + targetCountry.getName() + "! Opinion increased by " + opinionIncrease);
        } else {
            System.out.println("Not enough money to send a gift!");
        }
    }

    public void humiliate(Country targetCountry, int amount) {
        // Check if there is enough money to humiliate the target
        if (economy.subtractMoney(amount)) {
            int opinionDecrease = amount / 10; // Decrease opinion by 1 for each 10 ducats of insult
            opinion -= opinionDecrease;
            System.out.println("You humiliated " + targetCountry.getName() + "! Opinion decreased by " + opinionDecrease);
        } else {
            System.out.println("Not enough money to humiliate " + targetCountry.getName() + "!");
        }
    }

    public void breakAlliance(Country targetCountry) {
        targetCountry.getRelationshipManager().setRelationship(this.getCountry( targetCountry), RelationshipStatus.NEUTRAL);
        this.getCountry( targetCountry).getRelationshipManager().setRelationship(targetCountry, RelationshipStatus.NEUTRAL);
        diplomacyPoints += 2; // Return diplomacy points upon breaking an alliance
        System.out.println("Alliance broken with " + targetCountry.getName() + ".");
    }

    public void declareWar(Country targetCountry) {
        targetCountry.getRelationshipManager().setRelationship(this.getCountry(targetCountry), RelationshipStatus.AT_WAR);
        this.getCountry(targetCountry).getRelationshipManager().setRelationship(targetCountry, RelationshipStatus.AT_WAR);
        System.out.println("Declared war on " + targetCountry.getName() + "!");
    }

}
