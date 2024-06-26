package EOTFK;

import java.io.Serializable;

public class Character implements Serializable {
    private String name;
    protected int level;
    protected int exp;
    protected double health;
    protected double maxHealth;
    protected int attack;
    protected int defense;
    protected int mana;
    protected int maxMana;
    protected int rarity;
    protected int areaID;
    protected int bossID;
    protected int gold;
    private Weapon weapon;
    private Armor armor;

    public Character(String name, int level, int exp, double health, double maxHealth, int attack, int defense,
            int gold,
            Weapon weapon, Armor armor) {
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.gold = gold;
        this.weapon = weapon;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public int getBossID() {
        return bossID;
    }

    public void setBossID(int bossID) {
        this.bossID = bossID;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
