package Spirit;

public class Equipment {

    protected String name;
    protected int attack;
    protected int defense;
    protected int health;
    protected int requirement;
    protected String effect;

    public Equipment(String name, int requirement, String effect) {
        this.name = name;
        this.requirement = requirement;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
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

    public int getRequirement() {
        return requirement;
    }

    public void setRequirement(int requirement) {
        this.requirement = requirement;
    }

    public String getEffect() {
        return effect;
    }

    public void setAbility(String effect) {
        this.effect = effect;
    }
}
