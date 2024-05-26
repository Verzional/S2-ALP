package Spirit;

public class Weapon extends Equipment{
    
    public Weapon(String name, String description, int requirement, String effect, int attack, int price){
        super(name, description, requirement, effect, price);
        this.attack = attack;
    }
}
