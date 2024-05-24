package Spirit;

public class Quest {
    private String name;
    private String description;
    private int level;
    private int difficulty;
    private int reward;
    private boolean completed;

    public Quest(String name, String description, int level, int difficulty, int reward, boolean completed) {
        this.name = name;
        this.description = description;
        this.level = level;
        this.difficulty = difficulty;
        this.reward = reward;
        this.completed = false;
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}