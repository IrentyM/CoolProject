package models;

public class Diplomacy {
    private int diplomacyPoints;
    private int opinion;

    public Diplomacy(int diplomacyPoints) {
        this.diplomacyPoints = diplomacyPoints;
        this.opinion = 0; // Default opinion value
    }

    // Getter for diplomacy points
    public int getDiplomacyPoints() {
        return diplomacyPoints;
    }

    // Check if an alliance can be formed (requires at least 2 diplomacy points)
    public boolean canFormAlliance() {
        return diplomacyPoints >= 2 && opinion > 0;
    }

    // Check if a non-aggression pact can be formed (requires at least 1 diplomacy point)
    public boolean canFormNonAggressionPact() {
        return diplomacyPoints >= 1 && opinion > 0;
    }

    // Form an alliance (costs 2 diplomacy points)
    public void formAlliance(Country targetCountry) {
        if (canFormAlliance()) {
            diplomacyPoints -= 2;
            opinion += 50; // Increase opinion due to forming an alliance
            System.out.println("Alliance formed with " + targetCountry.getName() + "!");
        } else {
            System.out.println("Not enough diplomacy points or opinion is too low to form an alliance.");
        }
    }

    // Form a non-aggression pact (costs 1 diplomacy point)
    public void formNonAggressionPact(Country targetCountry) {
        if (canFormNonAggressionPact()) {
            diplomacyPoints -= 1;
            opinion += 25; // Increase opinion due to forming a pact
            System.out.println("Non-aggression pact formed with " + targetCountry.getName() + "!");
        } else {
            System.out.println("Not enough diplomacy points or opinion is too low to form a non-aggression pact.");
        }
    }

    // Send a gift (increases opinion by spending money)
    public void sendGift(Country targetCountry, int amount) {
        int opinionIncrease = amount / 10;
        opinion += opinionIncrease; // Each 10 ducats increases opinion by 1
        System.out.println("Gift sent to " + targetCountry.getName() + "! Opinion increased by " + opinionIncrease);
    }

    // Humiliate the target country (decreases opinion)
    public void humiliate(Country targetCountry, int amount) {
        int opinionDecrease = amount / 10;
        opinion -= opinionDecrease; // Decrease opinion by 1 for each 10 ducats of insult
        System.out.println("You humiliated " + targetCountry.getName() + "! Opinion decreased by " + opinionDecrease);
    }

    // Break an alliance (restores diplomacy points and decreases opinion)
    public void breakAlliance(Country targetCountry) {
        diplomacyPoints += 2; // Restore 2 diplomacy points
        opinion -= 70; // Decrease opinion significantly
        System.out.println("Alliance broken with " + targetCountry.getName() + "!");
    }

    // Getter for opinion
    public int getOpinion() {
        return opinion;
    }

    // Method to modify opinion based on war status
    public void adjustOpinionForWar(Country targetCountry, boolean isAtWarWithSameEnemy, boolean allyAtWarWithThirdParty) {
        if (isAtWarWithSameEnemy) {
            opinion += 20; // Increase opinion for fighting the same enemy
            System.out.println("Opinion of " + targetCountry.getName() + " increased due to fighting the same enemy.");
        } else if (allyAtWarWithThirdParty) {
            opinion -= 20; // Decrease opinion for ally fighting a third party
            System.out.println("Opinion of " + targetCountry.getName() + " decreased due to ally at war with a third party.");
        }
    }
}