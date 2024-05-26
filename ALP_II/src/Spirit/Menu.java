package Spirit;

import java.util.*;
import java.io.*;

public class Menu {

    Scanner scan = new Scanner(System.in);

    Player player;

    private ArrayList<Items> storeI = new ArrayList<Items>();
    private ArrayList<Items> inItems = new ArrayList<Items>();
    private ArrayList<Equipment> storeE = new ArrayList<Equipment>();
    private ArrayList<Equipment> inEquipment = new ArrayList<Equipment>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private ArrayList<Enemy> bosses = new ArrayList<Enemy>();
    private ArrayList<Quest> quests = new ArrayList<Quest>();
    private ArrayList<Area> areas = new ArrayList<Area>();
    private ArrayList<Abilities> abilities = new ArrayList<Abilities>();

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
            case 2 -> {
                loadGame();
                mainMenu();
            }
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
                <--------------------------------------------------------------------------------------->
                """);
        System.out.print("What is your name?: ");
        String name = scan.next() + scan.nextLine();
        System.out.println("");

        Weapon defaultWeapon = null;
        Armor defaultArmor = null;

        for (Equipment equipment : storeE) {
            if (equipment instanceof Weapon && equipment.getName().equals("Wooden Sword")) {
                defaultWeapon = (Weapon) equipment;
            } else if (equipment instanceof Armor && equipment.getName().equals("Leather Armor")) {
                defaultArmor = (Armor) equipment;
            }
        }

        player = new Player(name, 1, 0, 100, 100, 50, 50, 10, 5, 100, defaultWeapon, defaultArmor);
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
        System.out.println("<--- Areas --->");
        for (int i = 0; i < areas.size(); i++) {
            System.out.println((i + 1) + ". " + areas.get(i).getName() + " || " + areas.get(i).getDescription() + " || "
                    + " || " + areas.get(i).getLevel());
        }
        System.out.print("Choose: ");
        int choice = scan.nextInt();
        if (player.getLevel() >= areas.get(choice - 1).getLevel()) {
            System.out.println("You have entered " + areas.get(choice - 1).getName());
            battle();
        } else {
            System.out.println("You are not strong enough to enter this area!");
        }
    }

    public void battle() {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance < 50) {
            int enemyIndex = rand.nextInt(enemies.size());
            System.out.println("A " + enemies.get(enemyIndex).getName() + " appears!");
            System.out.println("<--- Battle Menu --->");
            System.out.println("1. Attack");
            System.out.println("2. Ability");
            System.out.println("3. Use Item");
            System.out.println("4. Flee");
            System.out.print("Choose: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1 -> attack(enemies.get(enemyIndex));
                case 2 -> ability(enemies.get(enemyIndex));
                case 3 -> useItem();
                case 4 -> flee();
            }
        } else {
            int bossIndex = rand.nextInt(bosses.size());
            System.out.println("The " + bosses.get(bossIndex).getName() + " appears!");
            System.out.println("<--- Battle Menu --->");
            System.out.println("1. Attack");
            System.out.println("2. Ability");
            System.out.println("3. Use Item");
            System.out.println("4. Flee");
            System.out.print("Choose: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1 -> attack(bosses.get(bossIndex));
                case 2 -> ability(bosses.get(bossIndex));
                case 3 -> useItem();
                case 4 -> flee();
            }
        }
    }

    public void attack(Character enemy) {
        int damage = player.getAttack() - enemy.getDefense();
        if (damage <= 0) {
            damage = 1;
        }
        enemy.setHealth(enemy.getHealth() - damage);
        System.out.println("You attack the enemy for " + damage + " damage!");
        if (enemy.getHealth() <= 0) {
            System.out.println("You have defeated the enemy!");
            player.setMoney(player.getMoney() + enemy.getMoney());
            player.setExp(player.getExp() + enemy.getExp());
            System.out.println("You've earned $" + enemy.getMoney() + " and " + enemy.getExp() + " exp!");
        } else {
            int enemyDamage = enemy.getAttack() - player.getDefense();
            if (enemyDamage <= 0) {
                enemyDamage = 1;
            }
            player.setHealth(player.getHealth() - enemyDamage);
            System.out.println("The enemy attacks you for " + enemyDamage + " damage!");
            if (player.getHealth() <= 0) {
                System.out.println("You have been defeated!");
                System.out.println("Game Over!");
                System.exit(0);
            }
        }
    }

    public void ability(Character enemy) {
        System.out.println("<--- Abilities --->");
        for (int i = 0; i < abilities.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + abilities.get(i).getName() + " || " + abilities.get(i).getEffect() + " || "
                            + " || " + abilities.get(i).getRequirement());
        }
        System.out.print("Choose: ");
        int choice = scan.nextInt();
        if (player.getLevel() >= abilities.get(choice - 1).getRequirement()) {
            int damage = player.getAttack() - enemy.getDefense();
            if (damage <= 0) {
                damage = 1;
            }
            enemy.setHealth(enemy.getHealth() - damage);
            System.out.println(
                    "You use " + abilities.get(choice - 1).getName() + " on the enemy for " + damage + " damage!");
            if (enemy.getHealth() <= 0) {
                System.out.println("You have defeated the enemy!");
                player.setMoney(player.getMoney() + enemy.getMoney());
                player.setExp(player.getExp() + enemy.getExp());
                System.out.println("You've earned $" + enemy.getMoney() + " and " + enemy.getExp() + " exp!");
            } else {
                int enemyDamage = enemy.getAttack() - player.getDefense();
                if (enemyDamage <= 0) {
                    enemyDamage = 1;
                }
                player.setHealth(player.getHealth() - enemyDamage);
                System.out.println("The enemy attacks you for " + enemyDamage + " damage!");
                if (player.getHealth() <= 0) {
                    System.out.println("You have been defeated!");
                    System.out.println("Game Over!");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("You are not strong enough to use this ability!");
        }
    }

    public void useItem() {
        System.out.println("<--- Items --->");
        for (int i = 0; i < inItems.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + inItems.get(i).getName() + " || " + inItems.get(i).getDescription() + " || "
                            + inItems.get(i).getValue() + " || $" + inItems.get(i).getPrice());
        }
        System.out.print("Choose: ");
        int choice = scan.nextInt();
        if (inItems.get(choice - 1).getName().equals("Health Potion")) {
            player.setHealth(player.getHealth() + inItems.get(choice - 1).getValue());
            inItems.remove(choice - 1);
            System.out.println("You have used a Health Potion!");
        } else if (inItems.get(choice - 1).getName().equals("Mana Potion")) {
            player.setHealth(player.getHealth() + inItems.get(choice - 1).getValue());
            inItems.remove(choice - 1);
            System.out.println("You have used a Mana Potion!");
        } else if (inItems.get(choice - 1).getName().equals("Antidote")) {
            System.out.println("You have used an Antidote!");
        } else if (inItems.get(choice - 1).getName().equals("Elixir")) {
            player.setHealth(player.getHealth() + inItems.get(choice - 1).getValue());
            player.setHealth(player.getHealth() + inItems.get(choice - 1).getValue());
            inItems.remove(choice - 1);
            System.out.println("You have used an Elixir!");
        } else if (inItems.get(choice - 1).getName().equals("Revive Scroll")) {
            System.out.println("You have used a Revive Scroll!");
        }
    }

    public void flee() {
        System.out.println("You have fled from battle!");
    }

    public void shop() {
        System.out.println("Hello " + player.name + "!");
        System.out.println("Money: " + player.getMoney());
        System.out.println("Welcome to my store, how can I help you?");
        System.out.println("[1] Buy Equipments");
        System.out.println("[2] Buy Items");
        System.out.println("[3] Sell Equipments");
        System.out.println("[4] Sell Items");
        System.out.println("[0] Return");
        System.out.println("Choose: ");
        int choose = scan.nextInt();

        switch (choose) {
            case 1 ->
                buyEquipment();
            case 2 ->
                buyItems();
            case 3 ->
                sellEquipment();
            case 4 ->
                sellItems();
            case 0 ->
                back();

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
        if (player.getMoney() > storeE.get(choose).getPrice()) {
            player.setMoney(player.getMoney() - storeE.get(choose).getPrice());
            inEquipment.add(storeE.get(choose - 1));

        } else if (player.getMoney() < storeE.get(choose).getPrice()) {
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
        if (player.getMoney() > storeI.get(choose).getPrice()) {
            player.setMoney(player.getMoney() - storeI.get(choose).getPrice());
            inItems.add(storeI.get(choose - 1));

        } else if (player.getMoney() < storeI.get(choose).getPrice()) {
            System.out.println("You don't have enough money!");
        }

    }

    public void sellEquipment() {
        for (int i = 0; i < storeE.size(); i++) {
            System.out
                    .println((i + 1) + ". " + storeE.get(i).getName() + " || " + storeE.get(i).getDescription() + " || "
                            + storeE.get(i).getEffect() + " || $" + storeE.get(i).getPrice());
        }
        System.out.println("Choose: ");
        int choose = scan.nextInt();
        inEquipment.remove(storeE.get(choose - 1));
        player.setMoney(player.getMoney() + (0.75 * storeE.get(choose).getPrice()));
        System.out.println("You've earned $" + (0.75 * storeE.get(choose).getPrice()));
    }

    public void sellItems() {
        for (int i = 0; i < storeI.size(); i++) {
            System.out
                    .println((i + 1) + ". " + storeI.get(i).getName() + " || " + storeI.get(i).getDescription() + " || "
                            + storeI.get(i).getValue() + " || $" + storeI.get(i).getPrice());
        }
        System.out.println("Choose: ");
        int choose = scan.nextInt();
        inItems.remove(storeI.get(choose - 1));
        player.setMoney(player.getMoney() + (0.75 * storeI.get(choose).getPrice()));
        System.out.println("You've earned $" + (0.75 * storeI.get(choose).getPrice()));
    }

    public void back() {
        System.out.println("Are you sure want to go back? (Y/N)");
        String choose = scan.next() + scan.nextLine();
        if (choose.equalsIgnoreCase("Y")) {
            mainMenu();
        } else {
            shop();
        }
    }

    public void inventory() {
        System.out.println("<--- " + player.name + "'s Inventory --->");
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
        System.out.println("<--- " + player.name + "'s Abilities --->");
        for (int i = 0; i < abilities.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + abilities.get(i).getName() + " || " + abilities.get(i).getEffect() + " || "
                            + " || " + abilities.get(i).getRequirement());
        }
    }

    public void stats() {
        System.out.println("<--- " + player.name + "'s Stats --->");
        System.out.println("Level: " + player.getLevel());
        System.out.println("Exp: " + player.getExp());
        System.out.println("Health: " + player.getHealth());
        System.out.println("Attack: " + player.getAttack());
        System.out.println("Defense: " + player.getDefense());
        System.out.println("Money: " + player.getMoney());
    }

    public void saveGame() {
        try {
            FileWriter writer = new FileWriter("save.txt");
            writer.write("Name: " + player.getName() + "\n");
            writer.write("Level: " + player.getLevel() + "\n");
            writer.write("Exp: " + player.getExp() + "\n");
            writer.write("Health: " + player.getHealth() + "\n");
            writer.write("Max Health: " + player.getMaxHealth() + "\n");
            writer.write("Mana: " + player.getMana() + "\n");
            writer.write("Max Mana: " + player.getMaxMana() + "\n");
            writer.write("Attack: " + player.getAttack() + "\n");
            writer.write("Defense: " + player.getDefense() + "\n");
            writer.write("Money: " + player.getMoney() + "\n");
            writer.close();
            System.out.println("Game saved!");
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

    public void createArea() {
        areas.add(new Area("The Forgotten Citadel", "An ancient citadel, shrouded in mystery and shadows", 0, 1,
                400));
        areas.add(new Area("The Whispering Woods", "A dense forest, haunted by the spirits of the past", 5, 2, 800));
        areas.add(new Area("The Cursed Caverns", "A labyrinth of tunnels, infested with dark creatures", 10, 3,
                1200));
        areas.add(new Area("The Shadowed Peaks", "A treacherous mountain range, home to ancient evils", 15, 4, 1600));
        areas.add(new Area("The Abyssal Depths", "A dark abyss, where forgotten horrors lie in wait", 20, 5, 2000));
    }

    public void createAbility() {
        abilities.add(new Abilities("Fireball", "Unleash a fiery explosion on your enemies", 0));
        abilities.add(new Abilities("Ice Shard", "Summon a shard of ice to pierce your foes", 5));
        abilities.add(new Abilities("Thunderbolt", "Call down a bolt of lightning to smite your enemies", 10));
        abilities.add(new Abilities("Earthquake", "Rupture the earth to crush your enemies", 15));
        abilities.add(new Abilities("Tornado", "Summon a whirlwind to devastate your enemies", 20));
    }

    public void createArmor() {
        storeE.add(new Armor("Leather Armor", "A simple leather armor", 1, "No effect", 0, 50, 100));
        storeE.add(new Armor("Chainmail Armor", "A sturdy chainmail armor", 5, "No effect", 0, 50, 200));
        storeE.add(new Armor("Iron Armor", "A heavy iron armor", 10, "No effect", 0, 100, 300));
        storeE.add(new Armor("Steel Armor", "A gleaming steel armor", 15, "No effect", 0, 150, 400));
        storeE.add(new Armor("Silver Armor", "A shining silver armor", 20, "No effect", 0, 200, 500));
    }

    public void createWeapon() {
        storeE.add(new Weapon("Wooden Sword", "A simple wooden sword", 1, "No effect", 0, 50));
        storeE.add(new Weapon("Rusty Sword", "A rusty sword", 5, "No effect", 0, 50));
        storeE.add(new Weapon("Iron Sword", "A sturdy iron sword", 10, "No effect", 0, 100));
        storeE.add(new Weapon("Steel Sword", "A sharp steel sword", 15, "No effect", 0, 150));
        storeE.add(new Weapon("Silver Sword", "A gleaming silver sword", 20, "No effect", 0, 200));
        storeE.add(new Weapon("Shadow Blade", "A blade forged from shadows", 25, "No effect", 0, 250));
    }

    public void createItems() {
        storeI.add(new Items("Health Potion", "Restores 50 health", 50, 50));
        storeI.add(new Items("Mana Potion", "Restores 50 mana", 50, 50));
        storeI.add(new Items("Antidote", "Cures poison", 0, 50));
        storeI.add(new Items("Elixir", "Restores 100 health and mana", 100, 100));
        storeI.add(new Items("Revive Scroll", "Revives a fallen ally", 0, 100));
    }

    public void createEnemy() {
        enemies.add(new Enemy("Skeleton Warrior", 5, 0, 50, 50, 10, 5, 50, null, null));
        enemies.add(new Enemy("Ghoul", 10, 0, 100, 100, 20, 10, 100, null, null));
        enemies.add(new Enemy("Wraith", 15, 0, 150, 150, 30, 15, 150, null, null));
        enemies.add(new Enemy("Specter", 20, 0, 200, 200, 40, 20, 200, null, null));
        enemies.add(new Enemy("Shadow Beast", 25, 0, 250, 250, 50, 25, 250, null, null));
    }

    public void createBoss() {
        bosses.add(new Enemy("The Ancient Dragon", 5, 0, 1500, 1500, 60, 30, 1500, null, null));
        bosses.add(new Enemy("The Shadow Queen", 10, 0, 2000, 2000, 70, 35, 2000, null, null));
        bosses.add(new Enemy("The Thunder God", 15, 0, 2500, 2500, 80, 40, 2500, null, null));
        bosses.add(new Enemy("The Soul Reaper", 20, 0, 3000, 3000, 90, 45, 3000, null, null));
        bosses.add(new Enemy("The Dark Lord", 25, 0, 3500, 3500, 100, 50, 4000, null, null));
    }

    public void createQuest() {
        quests.add(new Quest("The Lost Relic", "Retrieve the ancient relic from the depths of the citadel", 0, 1, 400,
                false));
        quests.add(new Quest("The Cursed Amulet", "Break the curse of the amulet hidden in the Whispering Woods", 5, 2,
                800, false));
        quests.add(new Quest("The Abyssal Scepter", "Unleash the power of the abyssal scepter in the dark abyss", 10, 3,
                1200, false));
        quests.add(new Quest("The Forgotten Kingdom", "Unravel the mysteries of the forgotten kingdom", 25, 5,
                2500, false));
        quests.add(new Quest("The Final Confrontation",
                "Face the Dark Lord in a battle to decide the fate of the kingdom",
                20, 5, 2000, false));
    }
}
