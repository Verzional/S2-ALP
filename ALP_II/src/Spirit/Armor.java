package Spirit;

public class Armor extends Equipment{
    
    public Armor(String name, int requirement, String effect, int defense, int health){
        super(name, requirement, effect);
        this.defense = defense;
        this.health = health;
    }
}
