package Spirit;

public class Player extends Character {
    public Player(String name, int level, int exp, int health, int maxHealth, int mana, int maxMana, int attack,
            int defense, double money, Weapon weapon, Armor armor) {
        super(name, level, exp, health, maxHealth, attack, defense, money, weapon, armor);
        this.mana = mana;
        this.maxMana = maxMana;
    }

    public void levelUp() {
        if (exp >= level * 100) {
            level++;
            exp = 0;
            maxHealth += 10;
            health = maxHealth;
            maxMana += 5;
            mana = maxMana;
            attack += 2;
            defense += 1;
        }
    }
}