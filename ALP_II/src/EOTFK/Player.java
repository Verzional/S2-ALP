package EOTFK;

public class Player extends Character {
    public Player(String name, int level, int exp, float health, float maxHealth, int mana, int maxMana, int attack,
            int defense, int gold, Weapon weapon, Armor armor) {
        super(name, level, exp, health, maxHealth, attack, defense, gold, weapon, armor);
        this.mana = mana;
        this.maxMana = maxMana;
    }

    public void levelUp() {
        level++;
        maxHealth += 20;
        maxMana += 5;
        health = maxHealth;
        mana = maxMana;
        attack += 10;
        defense += 5;
    }
}
