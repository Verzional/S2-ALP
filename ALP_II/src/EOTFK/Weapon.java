package EOTFK;

public class Weapon extends Equipment{
    public Weapon(String name, String description, int weaponID, int levelRequirement, int cost, int attackBoost) {
        super(name, description, levelRequirement, cost);
        this.attackBoost = attackBoost;
        this.weaponID = weaponID;
    }
}
