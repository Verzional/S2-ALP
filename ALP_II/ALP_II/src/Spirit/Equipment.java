package Spirit;

public class Equipment {

    protected String name;
    protected String description;
    protected int attack;
    protected int defense;
    protected int health;
    protected int requirement;
    protected int price;
    protected String effect;

    public Equipment(String name, String description, int requirement, String effect, int price) {
        this.name = name;
        this.description = description;
        this.requirement = requirement;
        this.effect = effect;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDesc(String description) {
        this.description = description;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEffect() {
        return effect;
    }

    public void setAbility(String effect) {
        this.effect = effect;
    }
}
