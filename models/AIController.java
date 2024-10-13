package models;

public class AIController {
    private static AIActionStrategy strategy;

    public static void setStrategy(AIActionStrategy strategy) {
        AIController.strategy = strategy;
    }

    public static void performAction(Country country, Game game) {
        if (strategy != null) {
            strategy.executeAction(country,game);
        }
    }
}
