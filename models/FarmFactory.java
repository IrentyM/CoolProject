package models;

public class FarmFactory implements BuildingFactory {
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
