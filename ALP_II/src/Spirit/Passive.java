package Spirit;

public class Passive extends Abilities {
    public Passive(String name, String effect, int requirement, boolean active){
        super(name, effect, requirement);
        this.active = active;
    }
}
