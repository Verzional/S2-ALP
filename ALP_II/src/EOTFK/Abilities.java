package EOTFK;

import java.io.Serializable;

public class Abilities implements Serializable {

    private String name;
    private String effect;
    private int abilityID;
    private int manaCost;
    private int unlockLevel;
    private boolean isUnlocked;

    public Abilities(String name, String effect, int abilityID, int manaCost, int unlockLevel, boolean isUnlocked) {
        this.name = name;
        this.effect = effect;
        this.abilityID = abilityID;
        this.manaCost = manaCost;
        this.unlockLevel = unlockLevel;
        this.isUnlocked = isUnlocked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getAbilityID() {
        return abilityID;
    }

    public void setAbilityID(int abilityID) {
        this.abilityID = abilityID;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getUnlockLevel() {
        return unlockLevel;
    }

    public void setUnlockLevel(int unlockLevel) {
        this.unlockLevel = unlockLevel;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void setUnlocked(boolean unlocked) {
        isUnlocked = unlocked;
    }

    public void unlock() {
        isUnlocked = true;
    }
}
