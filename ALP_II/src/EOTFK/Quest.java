package EOTFK;

import java.io.Serializable;

public class Quest implements Serializable{
    private String name;
    private String description;
    private int questID;
    private int completionXP;
    private int completionGold;
    private boolean isUnlocked;
    private boolean isCompleted;

    public Quest(String name, String description, int questID, int completionXP, int completionGold, boolean isUnlocked, boolean isCompleted) {
        this.name = name;
        this.description = description;
        this.questID = questID;
        this.completionXP = completionXP;
        this.completionGold = completionGold;
        this.isUnlocked = isUnlocked;
        this.isCompleted = isCompleted;
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

    public int getQuestID() {
        return questID;
    }

    public void setQuestID(int questID) {
        this.questID = questID;
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

    public void setUnlocked(boolean unlocked) {
        isUnlocked = unlocked;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void completeQuest() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return name + ": " + description + " (XP: " + completionXP + ", Gold: " + completionGold + ")";
    }
}
