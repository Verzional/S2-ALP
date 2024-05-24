package Spirit;

public class Weapon extends Equipment{
    
    public Weapon(String name, int requirement, String effect, int attack){
        super(name, requirement, effect);
        this.attack = attack;
    }
}
