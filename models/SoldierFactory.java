package models;

public class SoldierFactory implements ISoldierFactory {
    @Override
    public Soldier createSoldier(String type, int amount) {
        switch (type.toLowerCase()) {
            case "infantry":
                return new Infantry(amount);  // Pass amount to Infantry
            case "cavalry":
                return new Cavalry(amount);   // Pass amount to Cavalry
            default:
                throw new IllegalArgumentException("Unknown soldier type: " + type);
        }
    }
}
