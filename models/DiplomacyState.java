package models;

class DiplomacyState implements TurnState {
    @Override
    public void manageTurn(Game context) {
        Country currentCountry = context.getCurrentCountry();
        Country targetCountry = Game.chooseTargetCountry();
        System.out.println("Diplomacy phase for " + currentCountry.getName());
        currentCountry.manageDiplomacy(currentCountry, targetCountry);
    }

    @Override
    public void nextState(Game context) {
        context.setState(new EconomyState());  // Move to the Economy phase
    }
}
