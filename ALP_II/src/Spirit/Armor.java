package Spirit;

public class Armor extends Equipment{
    
    public Armor(String name, String description, int requirement, String effect, int defense, int health, int price){
        super(name, description, requirement, effect, price);
        this.defense = defense;
        this.health = health;
    }
}
