package models;

class MilitaryState implements TurnState {
    @Override
    public void manageTurn(Game context) {
        Country currentCountry = context.getCurrentCountry();
        System.out.println("Military phase for " + currentCountry.getName());
        currentCountry.manageMilitary(currentCountry);
    }

    @Override
    public void nextState(Game context) {
        if (context.isLastCountryInTurn()) {
            context.setState(new EndTurnState());  // Move to End Turn state
        } else {
            context.moveToNextCountry();  // Move to the next country
            context.setState(new DiplomacyState());  // Start with Diplomacy for the next country
        }
    }
}



