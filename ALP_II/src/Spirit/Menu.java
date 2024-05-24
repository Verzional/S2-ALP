package Spirit;

import java.util.*;
import java.io.*;

public class Menu {

    Scanner scan = new Scanner(System.in);

    Character chara;
    Character enemy;
    Character boss;
    Quest quest;
    Abilities ability;
    Area area;
    Armor armor;
    Weapon weapon;
    Items item;

    private ArrayList<Items> storeI = new ArrayList<Items>();
    private ArrayList<Equipment> storeE = new ArrayList<Equipment>();
    private ArrayList<Items> inItems = new ArrayList<Items>();
    private ArrayList<Equipment> inEquipment = new ArrayList<Equipment>();
    private ArrayList<Quest> quests = new ArrayList<Quest>();
    private ArrayList<Abilities> abilities = new ArrayList<Abilities>();
    private ArrayList<Area> areas = new ArrayList<Area>();
    private ArrayList<Character> enemies = new ArrayList<Character>();
    private ArrayList<Character> bosses = new ArrayList<Character>();

    public Menu() {
        createAbility();
        createArmor();
        createWeapon();
        createEnemy();
        createBoss();
        createQuest();
        createArea();
        createItems();
    }

    public void start() {
        System.out.println("""
                <-------------------------------------------------------------------------->
                     Amidst the ruins of fallen kingdoms and the encroaching darkness,
                an undead warrior, cursed with immortality, sets forth on a harrowing quest.
                     Journey through treacherous landscapes, confront formidable foes,
                          and delve into the forgotten secrets of a lost kingdom.
                  Only by facing ancient entities and unraveling the mysteries of the past,
                      can balance be restored to a desolate world consumed by shadows
                <-------------------------------------------------------------------------->
                """);
        System.out.println("""
                <--- Echoes of The Forgotten Kingdom --->
                1. New Game
                2. Load Game
                3. Exit Game""");
        System.out.print("Choose: ");
        int choice = scan.nextInt();
        System.out.println("<--------------------------------------->\n");

        switch (choice) {
            case 1 ->
                prologue();
            case 2 ->
                mainMenu();
            case 3 ->
                exitGame();
        }
    }

    public void prologue() {
        System.out.println("""
                <--------------------------------------------------------------------------------------->
                                     You awaken in the ruins of an ancient citadel,
                                devoid of memories but burdened with a sense of purpose.
                Guided by whispers from the past, you set forth on a quest to reclaim your lost humanity,
                                  and unearth the truth behind the kingdom's downfall.
                <--------------------------------------------------------------------------------------->""");
        System.out.print("\nWhat is your name?: ");
        String name = scan.next() + scan.nextLine();
        System.out.println("");

        chara = new Character(name, 1, 0, 100, 10, 5, 100);
        mainMenu();
    }

    public void mainMenu() {
        do {
            System.out.println("""
                    <--- Menu --->
                    1. Travel
                    2. Shop
                    3. Inventory
                    4. Quests
                    5. Abilities
                    6. Stats
                    7. Save Game
                    8. Exit Game""");
            System.out.print("Choose: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1 ->
                    travel();
                case 2 ->
                    shop();
                case 3 ->
                    inventory();
                case 4 ->
                    quests();
                case 5 ->
                    abilities();
                case 6 ->
                    stats();
                case 7 ->
                    saveGame();
                case 8 ->
                    exitGame();
            }
        } while (true);
    }

    public void travel() {

    }

    public void shop() {
        System.out.println("Hello " + chara.name + "!");
        System.out.println("Welcome to my store, how can I help you?");
        System.out.println("[1] Buy Equipments");
        System.out.println("[2] Buy Items");
        System.out.println("[0] Return");
        System.out.println("Choose: ");
        int choose = scan.nextInt();

        switch (choose) {
            case 1 ->
                buyEquipment();
            case 2 ->
                buyItems();
        }
    }

    public void buyEquipment() {
        for (int i = 0; i < storeE.size(); i++) {
            System.out
                    .println((i + 1) + ". " + storeE.get(i).getName() + " || " + storeE.get(i).getDescription() + " || "
                            + storeE.get(i).getEffect() + " || $" + storeE.get(i).getPrice());
        }
        System.out.println("Choose: ");
        int choose = scan.nextInt();
        if (chara.getMoney() > storeE.get(choose).getPrice()) {
            chara.setMoney(chara.getMoney() - storeE.get(choose).getPrice());
            inEquipment.add(storeE.get(choose - 1));

        } else if (chara.getMoney() < storeE.get(choose).getPrice()) {
            System.out.println("You don't have enough money!");
        }

    }

    public void buyItems() {
        for (int i = 0; i < storeI.size(); i++) {
            System.out
                    .println((i + 1) + ". " + storeI.get(i).getName() + " || " + storeI.get(i).getDescription() + " || "
                            + storeI.get(i).getValue() + " || $" + storeI.get(i).getPrice());
        }
        System.out.println("Choose: ");
        int choose = scan.nextInt();
        if (chara.getMoney() > storeI.get(choose).getPrice()) {
            chara.setMoney(chara.getMoney() - storeI.get(choose).getPrice());
            inItems.add(storeI.get(choose - 1));

        } else if (chara.getMoney() < storeI.get(choose).getPrice()) {
            System.out.println("You don't have enough money!");
        }

    }

    public void sellEquipment() {

    }

    public void sellItems() {

    }

    public void inventory() {
        System.out.println("<--- " + chara.name + "'s Inventory --->");
        System.out.println("Equipments: ");
        for (int i = 0; i < inEquipment.size(); i++) {
            System.out.println((i + 1) + ". " + inEquipment.get(i).getName() + " || "
                    + inEquipment.get(i).getDescription() + " || "
                    + inEquipment.get(i).getEffect() + " || $" + inEquipment.get(i).getPrice());
        }

        System.out.println("Items: ");
        for (int i = 0; i < inItems.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + inItems.get(i).getName() + " || " + inItems.get(i).getDescription() + " || "
                            + inItems.get(i).getValue() + " || $" + inItems.get(i).getPrice());
        }
    }

    public void quests() {
        System.out.println("<--- Quests --->");
        for (int i = 0; i < quests.size(); i++) {
            System.out
                    .println((i + 1) + ". " + quests.get(i).getName() + " || " + quests.get(i).getDescription() + " || "
                            + " || $" + quests.get(i).getReward());
        }
    }

    public void abilities() {
        System.out.println("<--- " + chara.name + "'s Abilities --->");
        for (int i = 0; i < abilities.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + abilities.get(i).getName() + " || " + abilities.get(i).getEffect() + " || "
                            + " || " + abilities.get(i).getRequirement());
        }
    }

    public void stats() {
        System.out.println("<--- " + chara.name + "'s Stats --->");
        System.out.println("Level: " + chara.getLevel());
        System.out.println("Exp: " + chara.getExp());
        System.out.println("Health: " + chara.getHealth());
        System.out.println("Attack: " + chara.getAttack());
        System.out.println("Defense: " + chara.getDefense());
        System.out.println("Money: " + chara.getMoney());
    }

    public void createArea() {
        area = new Area("The Forgotten Citadel", "An ancient citadel, shrouded in mystery and shadows", 0, 1, 400);
        area = new Area("The Whispering Woods", "A dense forest, haunted by the spirits of the past", 5, 2, 800);
        area = new Area("The Cursed Caverns", "A labyrinth of tunnels, infested with dark creatures", 10, 3, 1200);
        area = new Area("The Shadowed Peaks", "A treacherous mountain range, home to ancient evils", 15, 4, 1600);
        area = new Area("The Abyssal Depths", "A dark abyss, where forgotten horrors lie in wait", 20, 5, 2000);
        areas.add(area);
    }

    public void createAbility() {
        ability = new Abilities("Cleave", "Unleash a powerful cleave attack on your enemies", 0);
        ability = new Abilities("Fireball", "Summon a fiery fireball to incinerate your foes", 5);
        ability = new Abilities("Healing Touch", "Heal yourself with a soothing touch of magic", 10);
        ability = new Abilities("Shadow Strike", "Strike from the shadows with deadly precision", 15);
        ability = new Abilities("Thunderbolt", "Summon a thunderbolt to smite your enemies", 20);
        abilities.add(ability);
    }

    public void createArmor() {
        armor = new Armor("Leather Armor", "Basic leather armor", 5, "No effect", 0, 0, 50);
        armor = new Armor("Chainmail Armor", "Sturdy chainmail armor", 10, "No effect", 0, 0, 100);
        armor = new Armor("Plate Armor", "Heavy plate armor", 15, "No effect", 0, 0, 150);
        armor = new Armor("Dragon Scale Armor", "Armor made from the scales of a dragon", 20, "No effect", 0, 0, 200);
        armor = new Armor("Shadow Cloak", "A cloak that shrouds you in shadows", 25, "No effect", 0, 0, 250);
        storeE.add(armor);
    }

    public void createWeapon() {
        weapon = new Weapon("Rusty Sword", "A rusty sword", 5, "No effect", 0, 50);
        weapon = new Weapon("Iron Sword", "A sturdy iron sword", 10, "No effect", 0, 100);
        weapon = new Weapon("Steel Sword", "A sharp steel sword", 15, "No effect", 0, 150);
        weapon = new Weapon("Silver Sword", "A gleaming silver sword", 20, "No effect", 0, 200);
        weapon = new Weapon("Shadow Blade", "A blade forged from shadows", 25, "No effect", 0, 250);
        storeE.add(weapon);
    }

    public void createItems() {
        item = new Items("Health Potion", "Restores 50 health", 0, 50);
        item = new Items("Mana Potion", "Restores 50 mana", 0, 50);
        item = new Items("Antidote", "Cures poison", 0, 0);
        item = new Items("Elixir", "Restores 100 health and mana", 0, 100);
        item = new Items("Revive Scroll", "Revives a fallen ally", 0, 0);
        storeI.add(item);
    }

    public void createEnemy() {
        enemy = new Character("Skeleton Warrior", 5, 0, 50, 10, 5, 50);
        enemy = new Character("Ghoul", 10, 0, 100, 20, 10, 100);
        enemy = new Character("Wraith", 15, 0, 150, 30, 15, 150);
        enemy = new Character("Vampire Lord", 20, 0, 200, 40, 20, 200);
        enemy = new Character("Lich King", 25, 0, 250, 50, 25, 250);
        enemies.add(enemy);
    }

    public void createBoss() {
        boss = new Character("The Ancient Dragon", 5, 0, 1500, 60, 30, 1500);
        boss = new Character("The Shadow Queen", 10, 0, 2000, 70, 35, 2000);
        boss = new Character("The Thunder God", 15, 0, 2500, 80, 40, 2500);
        boss = new Character("The Soul Reaper", 20, 0, 3000, 90, 45, 3000);
        boss = new Character("The Dark Lord", 25, 0, 1000, 50, 25, 1000);
        bosses.add(boss);
    }

    public void createQuest() {
        quest = new Quest("The Lost Relic", "Retrieve the ancient relic from the depths of the citadel", 0, 1, 400,
                false);
        quest = new Quest("The Cursed Amulet", "Break the curse of the amulet hidden in the Whispering Woods", 5, 2,
                800, false);
        quest = new Quest("The Abyssal Scepter", "Unleash the power of the abyssal scepter in the dark abyss", 10, 3,
                1200, false);
        quest = new Quest("The Shadowed Crown", "Claim the shadowed crown from the depths of the mountain", 15, 4,
                1600, false);
        quest = new Quest("The Final Confrontation", "Face the Dark Lord in a battle to decide the fate of the kingdom",
                20, 5, 2000, false);
        quests.add(quest);
    }

    public void saveGame() {
        try {
            FileWriter writer = new FileWriter("save.txt");
            writer.write(chara.getName() + "\n");
            writer.write(chara.getLevel() + "\n");
            writer.write(chara.getExp() + "\n");
            writer.write(chara.getHealth() + "\n");
            writer.write(chara.getAttack() + "\n");
            writer.write(chara.getDefense() + "\n");
            writer.write(chara.getMoney() + "\n");
            writer.close();
            System.out.println("Game Saved!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void loadGame() {
        try {
            File file = new File("save.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void exitGame() {
        System.out.println("Farewell Warrior...");
        System.exit(0);
    }
}
