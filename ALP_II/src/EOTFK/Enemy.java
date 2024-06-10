package EOTFK;

public class Enemy extends Character {
    public Enemy(String name, int level, int exp, float health, float maxHealth, int attack, int defense, int rarity,
            int areaID, int bossID, int gold, Weapon weapon, Armor armor) {
        super(name, level, exp, health, maxHealth, attack, defense, gold, weapon, armor);
        this.rarity = rarity;
        this.areaID = areaID;
        this.bossID = bossID;
    }
}
