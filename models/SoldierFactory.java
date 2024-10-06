package models;

public class SoldierFactory implements ISoldierFactory {
    @Override
    public Soldier createSoldier(String type) {
        switch (type.toLowerCase()) {
            case "infantry":
                return new Infantry();
            case "cavalry":
                return new Cavalry();
            default:
                throw new IllegalArgumentException("Unknown soldier type: " + type);
        }
    }
}
