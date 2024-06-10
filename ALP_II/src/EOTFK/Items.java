package EOTFK;

import java.io.Serializable;

public class Items implements Serializable {
    private String name;
    private String effect;
    private int itemID;
    private int cost;

    public Items(String name, String effect, int itemID, int cost) {
        this.name = name;
        this.effect = effect;
        this.itemID = itemID;
        this.cost = cost;
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

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
