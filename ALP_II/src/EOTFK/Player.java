package EOTFK;

public class Player extends Character{
    public Player(String name, int level, int exp, int health, int maxHealth, int mana, int maxMana, int attack, int defense, double gold, Weapon weapon, Armor armor) {
        super(name, level, exp, health, maxHealth, attack, defense, gold, weapon, armor);
        this.mana = mana;
        this.maxMana = maxMana;
    }

    public void levelUp() {
        level++;
        maxHealth += 10;
        maxMana += 5;
        health = maxHealth;
        mana = maxMana;
        attack += 2;
        defense += 2;
    }
    
}
