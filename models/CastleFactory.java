package models;

public class CastleFactory implements BuildingFactory {
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
