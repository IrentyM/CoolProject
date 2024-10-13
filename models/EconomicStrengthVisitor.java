package models;

public class EconomicStrengthVisitor implements Visitor {
    private int totalStrength = 0;

    @Override
    public void visit(Country country) {
        System.out.println("Visiting country: " + country.getName());
    }

    @Override
    public void visit(Economy economy) {
        totalStrength += economy.getTotalWealth();
        System.out.println("Current economy strength: " + totalStrength);
    }

    @Override
    public void visit(Military military) {
        // This visitor doesn't need to interact with the military.
    }

    public int getTotalStrength() {
        return totalStrength;
    }
}

