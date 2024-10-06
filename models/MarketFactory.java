package models;

public class MarketFactory implements BuildingFactory {
    @Override
    public IBuilding createBuilding() {
        return new Market();
    }
}
