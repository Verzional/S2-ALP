package EOTFK;

public class Armor extends Equipment {
    public Armor(String name, String description, int armorID, int levelRequirement, int cost,
            int defenseBoost, int healthBoost) {
        super(name, description, levelRequirement, cost);
        this.defenseBoost = defenseBoost;
        this.healthBoost = healthBoost;
        this.armorID = armorID;
    }
}
