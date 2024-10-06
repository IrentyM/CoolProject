package models;

public class MarketFactory implements BuildingFactory {
    @Override
    public IBuilding createBuilding() {
        return new Castle();
    }
    public IBuilding deleteBuilding() {
        return new Castle();
    }
    public IBuilding upgradeBuilding() {
        return new Castle();
    }
}
