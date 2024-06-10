package EOTFK;

import java.io.Serializable;

public class Equipment implements Serializable {
    private String name;
    private String description;
    private int levelRequirement;
    private int cost;
    protected int weaponID;
    protected int armorID;
    protected int attackBoost;
    protected int defenseBoost;
    protected int healthBoost;

    public Equipment(String name, String description, int levelRequirement, int cost) {
        this.name = name;
        this.description = description;
        this.levelRequirement = levelRequirement;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAttackBoost() {
        return attackBoost;
    }

    public void setAttackBoost(int attackBoost) {
        this.attackBoost = attackBoost;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }

    public void setDefenseBoost(int defenseBoost) {
        this.defenseBoost = defenseBoost;
    }

    public int getHealthBoost() {
        return healthBoost;
    }

    public void setHealthBoost(int healthBoost) {
        this.healthBoost = healthBoost;
    }
}
