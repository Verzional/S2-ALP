package Spirit;

public class Armor extends Equipment{
    
    public Armor(String name, String description, int requirement, String effect, int defense, int health, int price){
        super(name, description, requirement, effect, price);
        this.defense = defense;
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
