package Spirit;

public class Area {
    String name;
    String description;
    int level;
    int difficulty;
    int reward;

    public Area(String name, String description, int level, int difficulty, int reward) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.difficulty = difficulty;
        this.reward = reward;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
}