package models;

public class AIController {
    private AIActionStrategy strategy;

    public void setStrategy(AIActionStrategy strategy) {
        this.strategy = strategy;
    }

    public void performAction(Country country, Game game) {
        if (strategy != null) {
            strategy.executeAction(country,game);
        }
    }
}

