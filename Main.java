import models.Game;
public class
Main {
    public static void main(String[] args) {
        Game context = new Game();
        while (!context.isGameOver()) {
            context.nextTurn();  // Play through the current country's phases
            if (context.isLastCountryInTurn()) {
                context.startNewTurn();  // Move to the next turn
            } else {
                context.moveToNextCountry();  // Move to the next country
            }
        }
        System.out.println("Game Over!");
    }
}
