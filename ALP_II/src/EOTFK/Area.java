package EOTFK;

import java.io.Serializable;

public class Area implements Serializable{
    private String name;
    private String description;
    private int areaID;
    private int completionXP;
    private int completionGold;
    private boolean isUnlocked;

    public Area(String name, String description, int areaID, int completionXP, int completionGold, boolean isUnlocked) {
        this.name = name;
        this.description = description;
        this.areaID = areaID;
        this.completionXP = completionXP;
        this.completionGold = completionGold;
        this.isUnlocked = isUnlocked;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public int getCompletionXP() {
        return completionXP;
    }

    public void setCompletionXP(int completionXP) {
        this.completionXP = completionXP;
    }

    public int getCompletionGold() {
        return completionGold;
    }

    public void setCompletionGold(int completionGold) {
        this.completionGold = completionGold;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void unlock(){
        this.isUnlocked = true;
    }
}
