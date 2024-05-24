package Spirit;

public class Items {
    String name;
    String description;
    int price;
    int value;

    public Items(String name, String description, int price, int value){
        this.name = name;
        this.description = description;
        this.price = price;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }
}
