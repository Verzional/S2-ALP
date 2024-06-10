package EOTFK;

import java.util.*;
import java.io.*;

public class Menu {

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    Player player;
    Populate populate;

    private LinkedList<Items> items = new LinkedList<>();
    private LinkedList<Abilities> abilities = new LinkedList<>();
    private LinkedList<Weapon> weapons = new LinkedList<>();
    private LinkedList<Armor> armors = new LinkedList<>();

    public Menu() {
        populate = new Populate();
        populateGame();
    }

    public final void populateGame() {
        populate.createAbility();
        populate.createArea();
        populate.createArmor();
        populate.createWeapon();
        populate.createItems();
        populate.createBoss();
        populate.createCavernsEnemy();
        populate.createCitadelEnemy();
        populate.createDepthsEnemy();
        populate.createPeaksEnemy();
        populate.createWoodsEnemy();
    }

    public final void populateItem(){
        items.add(new Items("Health Potion", "Restores 20 health", 1, 10, 20));
    }

    public void start() {
        try {
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
                }
                case 3 ->
                    exitGame();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scan.next();
        }
    }

    public void prologue() {
        System.out.println(
                """
                        <--------------------------------------------------------------------------------------->
                                                You awaken in the ruins of an ancient city,
                                         devoid of memories but burdened with a sense of purpose.
                        Guided by whispers from the past, you set forth on a quest to reclaim your lost humanity,
                                           and unearth the truth behind the kingdom's downfall.
                        <--------------------------------------------------------------------------------------->
                                                        """);
        System.out.print("What is your name?: ");
        String name = scan.next() + scan.nextLine();

        player = new Player(name, 1, 0, 20, 20, 10, 10, 10, 5, 50,
                new Weapon("Wooden Sword", "A Normal Wooden Sword", 1, 1, 0, 10),
                new Armor("Leather Armor", "A Normal Leather Armor", 1,
                        1, 0, 5, 5));
        mainMenu();
    }

    public void mainMenu() {
        do {
            try {
                System.out.println("""

                        <--- Menu --->
                        1. Travel
                        2. Shop
                        3. Inventory
                        4. Abilities
                        5. Stats
                        6. Exit Game""");
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
                        abilities();
                    case 5 ->
                        stats();
                    case 6 ->
                        exitGame();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scan.next();
            }
        } while (true);
    }

    public void travel() {
        System.out.println("\n<--- Travel --->");
        for (Area area : populate.getAreas()) {
            if (area.isUnlocked()) {
                System.out.println(area.getAreaID() + ". " + area.getName());
            }
        }
        System.out.print("Choose: ");
        int choice = scan.nextInt();

        if (choice < 1 || choice > populate.getAreas().size()
                || !populate.getAreas().get(choice - 1).isUnlocked()) {
            System.out.println("Invalid choice. Please choose an unlocked area.");
            return;
        }

        Area selectedArea = populate.getAreas().get(choice - 1);
        System.out.println("Traveling to " + selectedArea.getName() + "...");
        battle(selectedArea.getAreaID());
    }

    public void battle(int areaID) {
        int stage = 1;
        do {
            if (player.getExp() >= player.getLevel() * 100) {
                player.levelUp();
                System.out.println("You have leveled up!");
            }

            Enemy enemy = null;
            Enemy bossEnemy = null;
            int enemyID;

            if (stage >= 1 && stage <= 2) {
                enemyID = 0;
            } else if (stage >= 3 && stage <= 5) {
                enemyID = 1;
            } else if (stage >= 6 && stage <= 8) {
                enemyID = 2;
            } else {
                enemyID = 3;
            }

            switch (areaID) {
                case 1 -> {
                    enemy = populate.getCitadelEnemies().get(enemyID);
                    bossEnemy = populate.getBossEnemies().get(0);
                }
                case 2 -> {
                    enemy = populate.getWoodsEnemies().get(enemyID);
                    bossEnemy = populate.getBossEnemies().get(1);
                }
                case 3 -> {
                    enemy = populate.getCavernsEnemies().get(enemyID);
                    bossEnemy = populate.getBossEnemies().get(2);
                }
                case 4 -> {
                    enemy = populate.getPeaksEnemies().get(enemyID);
                    bossEnemy = populate.getBossEnemies().get(3);
                }
                case 5 -> {
                    enemy = populate.getDepthsEnemies().get(enemyID);
                    bossEnemy = populate.getBossEnemies().get(4);
                }
            }

            if (stage == 10) {
                enemy = bossEnemy;
            }

            if (stage == 10) {
                System.out.println("\n<--- Final Stage --->");
            } else {
                System.out.println("\n<--- Stage " + stage + " --->");
            }
            do {
                System.out.println("\n<--- " +enemy.getName() +" -->");
                System.out.println("Level: " + enemy.getLevel());
                System.out.println("Health: " + enemy.getHealth());
                System.out.println("Attack: " + enemy.getAttack());
                System.out.println("Defense: " + enemy.getDefense());

                System.out.println("\n<--- Player --->");
                System.out.println("Level: " + player.getLevel());
                System.out.println("Health: " + player.getHealth());
                System.out.println("Attack: " + player.getAttack());
                System.out.println("Defense: " + player.getDefense());

                System.out.println("\n<--- Actions --->");
                System.out.println("1. Attack");
                System.out.println("2. Use Ability");
                System.out.println("3. Use Item");
                System.out.println("4. Flee");
                System.out.print("Choose: ");
                int choice = scan.nextInt();

                switch (choice) {
                    case 1 -> {
                        int playerDamage = player.getAttack() - enemy.getDefense();
                        int enemyDamage = enemy.getAttack() - player.getDefense();

                        if (playerDamage <= 0) {
                            playerDamage = 1;
                        }

                        if (enemyDamage <= 0) {
                            enemyDamage = 1;
                        }

                        enemy.setHealth(enemy.getHealth() - playerDamage);
                        player.setHealth(player.getHealth() - enemyDamage);

                        System.out.println(
                                "\nYou dealt " + playerDamage + " damage to the enemy!");
                        System.out.println(
                                "The enemy dealt " + enemyDamage + " damage to you!\n");

                        if (enemy.getHealth() <= 0) {
                            enemy.setHealth(enemy.getMaxHealth());
                            System.out.println("\n" + enemy.getName() + " has been defeated!");
                            player.setGold(player.getGold() + enemy.getGold());
                            player.setExp(player.getExp() + enemy.getExp());
                            System.out.println(
                                    "You have gained " + enemy.getExp() + " exp!");
                            System.out.println("You have gained " + enemy.getGold()
                                    + " gold!");
                            enemyDropRate(enemy, player);
                            System.out.println("""

                                    [1] Continue
                                    [2] Inventory
                                    [3] Return
                                    """);
                            System.out.print("Choose: ");
                            int continueChoice = scan.nextInt();

                            switch (continueChoice) {
                                case 1 -> {
                                    stage++;
                                    break;
                                }
                                case 2 -> {
                                    inventory();
                                }
                                case 3 -> {
                                    mainMenu();
                                }
                            }
                            break;
                        } else if (player.getHealth() <= 0) {
                            System.out.println("Immortality has its limits...");
                            mainMenu();
                        }
                    }
                    case 2 -> {
                        if (abilities.isEmpty()) {
                            System.out.println("No abilities available.");
                        } else {
                            System.out.println("Choose an ability to use: ");
                            for (int i = 0; i < abilities.size(); i++) {
                                System.out.println((i + 1) + ". "
                                        + abilities.get(i).getName());
                            }
                            System.out.print("Choose: ");
                            int abilityChoice = scan.nextInt();
                            int playerDamage = player.getAttack()
                                    + abilities.get(abilityChoice - 1)
                                            .getAbilityID()
                                    - enemy.getDefense();
                            int enemyDamage = enemy.getAttack() - player.getDefense();

                            if (playerDamage <= 0) {
                                playerDamage = 1;
                            }

                            if (enemyDamage <= 0) {
                                enemyDamage = 1;
                            }

                            enemy.setHealth(enemy.getHealth() - playerDamage);
                            player.setHealth(player.getHealth() - enemyDamage);

                            System.out.println("\nYou dealt " + playerDamage
                                    + " damage to the enemy!");
                            System.out.println("The enemy dealt " + enemyDamage
                                    + " damage to you!");

                            if (enemy.getHealth() <= 0) {
                                enemy.setHealth(enemy.getMaxHealth());
                                System.out.println("\n" + enemy.getName()
                                        + " has been defeated!");
                                player.setGold(player.getGold() + enemy.getGold());
                                player.setExp(player.getExp() + enemy.getExp());
                                System.out.println("\nYou have gained " + enemy.getExp()
                                        + " exp!");
                                System.out.println("You have gained " + enemy.getGold()
                                        + " gold!");
                                enemyDropRate(enemy, player);
                                System.out.println("""

                                        [1] Continue
                                        [2] Inventory
                                        [3] Return
                                        """);
                                System.out.print("Choose: ");
                                int continueChoice = scan.nextInt();

                                switch (continueChoice) {
                                    case 1 -> {
                                        stage++;
                                        break;
                                    }
                                    case 2 -> {
                                        inventory();
                                    }
                                    case 3 -> {
                                        mainMenu();
                                    }
                                }
                                break;
                            } else if (player.getHealth() <= 0) {
                                System.out.println("Immortality has its limits...");
                                mainMenu();
                            }
                        }
                    }
                    case 3 -> {
                        if (items.isEmpty()) {
                            System.out.println("No items available.");
                        } else {
                            System.out.println("Choose an item to use: ");
                            for (int i = 0; i < items.size(); i++) {
                                System.out.println((i + 1) + ". "
                                        + items.get(i).getName());
                            }
                            System.out.print("Choose: ");
                            int itemChoice = scan.nextInt();
                            player.setHealth(player.getHealth()
                                    + items.get(itemChoice - 1).getValue());
                        }
                    }
                    case 4 -> {
                        System.out.println("You fled from the enemy!");
                        mainMenu();
                    }
                }
            } while (player.getHealth() > 0 && enemy.getHealth() > 0);
            if (stage == 11) {
                System.out.println("\nArea cleared! " + populate.getAreas().get(areaID - 1).getName()
                        + " has been conquered!");
                player.setExp(player.getExp() + populate.getAreas().get(areaID - 1).getCompletionXP());
                player.setGold(player.getGold()
                        + populate.getAreas().get(areaID - 1).getCompletionGold());
                System.out.println("\nYou have gained "
                        + populate.getAreas().get(areaID - 1).getCompletionXP() + " exp!");
                System.out.println("You have gained "
                        + populate.getAreas().get(areaID - 1).getCompletionGold() + " gold!");
                System.out.println("\nYou have unlocked the next area!");
                populate.getAreas().get(areaID).unlock();
                mainMenu();
            }
        } while (stage != 11);
    }

    public void enemyDropRate(Enemy enemy, Player player) {
        int dropChance;
        dropChance = switch (enemy.getRarity()) {
            case 1 ->
                50;
            case 2 ->
                40;
            case 3 ->
                30;
            case 4 ->
                20;
            case 5 ->
                10;
            default ->
                5;
        };

        int chance = rand.nextInt(100);
        if (chance < dropChance) {
            int itemChance = rand.nextInt(2);
            if (itemChance == 0) {
                Weapon droppedWeapon = enemy.getWeapon();
                weapons.add(droppedWeapon);
                System.out.println("\nYou have obtained " + droppedWeapon.getName() + "!");
            } else {
                Armor droppedArmor = enemy.getArmor();
                armors.add(droppedArmor);
                System.out.println("\nYou have obtained " + droppedArmor.getName() + "!");
            }
        }
    }

    public void shop() {
        System.out.println("\n<--- Aaron's Shop --->");
        System.out.println("Hello " + player.getName() + "! Welcome to my Shop!");
        System.out.println("Gold: " + player.getGold());
        System.out.println("""

                <--- Shop --->
                [1] Buy
                [2] Sell
                [0] Return
                """);
        System.out.print("Choose: ");
        int choose = scan.nextInt();

        switch (choose) {
            case 1 ->
                buy();
            case 2 ->
                sell();
            case 0 ->
                mainMenu();
        }
    }

    public void buy() {
        System.out.println("""

                <--- Buy --->
                [1] Weapons
                [2] Armors
                [3] Items
                [0] Return
                """);
        System.out.print("Choose: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1 ->
                buyWeapon();
            case 2 ->
                buyArmor();
            case 3 ->
                buyItems();
            case 0 ->
                shop();
        }
    }

    public void buyWeapon() {
        for (int i = 0; i < populate.getStoreWeapons().size(); i++) {
            System.out
                    .println((i + 1) + ". " + populate.getStoreWeapons().get(i).getName() + " || "
                            + populate.getStoreWeapons().get(i).getDescription() + " || "
                            + populate.getStoreWeapons().get(i).getAttackBoost()
                            + " Attack || $" + populate.getStoreWeapons().get(i).getCost()
                            + " || Required Level: "
                            + populate.getStoreWeapons().get(i).getLevelRequirement());
        }
        System.out.print("Choose: ");
        int choose = scan.nextInt();
        if (player.getLevel() >= populate.getStoreWeapons().get(choose).getLevelRequirement()) {
            if (player.getGold() > populate.getStoreWeapons().get(choose).getCost()) {
                player.setGold(player.getGold() - populate.getStoreWeapons().get(choose).getCost());
                weapons.add(populate.getStoreWeapons().get(choose - 1));
            } else if (player.getGold() < populate.getStoreWeapons().get(choose).getCost()) {
                System.out.println("You don't have enough gold!");
            }
        } else {
            System.out.println("You need to be at least level "
                    + populate.getStoreWeapons().get(choose).getLevelRequirement()
                    + " to buy this.");
        }
    }

    public void buyArmor() {
        for (int i = 0; i < populate.getStoreArmor().size(); i++) {
            System.out.println((i + 1) + ". " + populate.getStoreArmor().get(i).getName() + " || "
                    + populate.getStoreArmor().get(i).getDescription() + " || "
                    + populate.getStoreArmor().get(i).getDefenseBoost() + " Defense" + " || "
                    + populate.getStoreArmor().get(i).getHealthBoost() + " Health" + " || $"
                    + populate.getStoreArmor().get(i).getCost() + " || Required Level: "
                    + populate.getStoreArmor().get(i).getLevelRequirement());
        }
        System.out.print("Choose: ");
        int choose = scan.nextInt();
        if (player.getLevel() >= populate.getStoreArmor().get(choose).getLevelRequirement()) {
            if (player.getGold() > populate.getStoreArmor().get(choose).getCost()) {
                player.setGold(player.getGold() - populate.getStoreArmor().get(choose).getCost());
                armors.add(populate.getStoreArmor().get(choose - 1));
            } else if (player.getGold() < populate.getStoreArmor().get(choose).getCost()) {
                System.out.println("You don't have enough gold!");
            }
        } else {
            System.out.println("You need to be at least level "
                    + populate.getStoreArmor().get(choose).getLevelRequirement() + " to buy this.");
        }
    }

    public void buyItems() {
        for (int i = 0; i < populate.getStoreItems().size(); i++) {
            System.out.println((i + 1) + ". " + populate.getStoreItems().get(i).getName() + " || "
                    + populate.getStoreItems().get(i).getEffect() + " || $"
                    + populate.getStoreItems().get(i).getCost());
        }
        System.out.print("Choose: ");
        int choose = scan.nextInt();
        if (player.getGold() > populate.getStoreItems().get(choose).getCost()) {
            player.setGold(player.getGold() - populate.getStoreItems().get(choose).getCost());
            items.add(populate.getStoreItems().get(choose - 1));
        } else if (player.getGold() < populate.getStoreItems().get(choose).getCost()) {
            System.out.println("You don't have enough gold!");
        }
    }

    public void sell() {
        System.out.println("""

                <--- Sell --->
                [1] Weapons
                [2] Armors
                [3] Items
                [0] Return
                """);
        System.out.print("Choose: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1 ->
                sellWeapon();
            case 2 ->
                sellArmor();
            case 3 ->
                sellItems();
            case 0 ->
                shop();
        }
    }

    public void sellWeapon() {
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println((i + 1) + ". " + weapons.get(i).getName() + " || "
                    + weapons.get(i).getDescription() + " || "
                    + weapons.get(i).getAttackBoost() + " Attack");
        }
        System.out.print("Choose: ");
        int choice = scan.nextInt();
        player.setGold(player.getGold() + weapons.get(choice - 1).getCost());
        weapons.remove(choice - 1);
    }

    public void sellArmor() {
        for (int i = 0; i < armors.size(); i++) {
            System.out.println((i + 1) + ". " + armors.get(i).getName() + " || "
                    + armors.get(i).getDescription() + " || "
                    + armors.get(i).getDefenseBoost() + " Defense" + " || "
                    + armors.get(i).getHealthBoost() + " Health");
        }
        System.out.print("Choose: ");
        int choice = scan.nextInt();
        player.setGold(player.getGold() + armors.get(choice - 1).getCost());
        armors.remove(choice - 1);
    }

    public void sellItems() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName() + " || "
                    + items.get(i).getEffect());
        }
        System.out.print("Choose: ");
        int choice = scan.nextInt();
        player.setGold(player.getGold() + items.get(choice - 1).getCost());
        items.remove(choice - 1);
    }

    public void inventory() {
        System.out.println("""

                <--- Inventory --->
                [1] Items
                [2] Weapons
                [3] Armors
                [0] Return
                """);
        System.out.print("Choose: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1 ->
                items();
            case 2 ->
                weapons();
            case 3 ->
                armors();
            case 0 ->
                scan.nextLine();
        }
    }

    public void items() {
        System.out.println("\n<--- Items --->");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + items.get(i).getName() + " || " + items.get(i).getEffect());
        }
        System.out.println("[1] Use Item");
        System.out.println("[0] Return");
        System.out.print("Choose: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1 ->
                useItem();
            case 0 ->
                inventory();
        }
    }

    public void useItem() {
        if (items.isEmpty()) {
            System.out.println("\n<--- Items --->");
            System.out.println("No items available.");
        } else {
            System.out.println("\n<--- Items --->");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).getName() + " || " + items.get(i).getEffect());
            }
            System.out.print("Choose an item by its number: ");
            int choice = scan.nextInt();

            if (choice < 1 || choice > items.size()) {
                System.out.println("Invalid choice.");
            } else {
                Items selectedItem = items.get(choice - 1);
                int itemID = selectedItem.getItemID();
                applyEffect(itemID);
                items.remove(choice - 1); 
            }
        }
    }

    private void applyEffect(int itemID) {
        switch (itemID) {
            case 1:
                System.out.println("Using Health Potion");
                System.out.println("20 Health Restored");
                player.setHealth(player.getHealth() + populate.getStoreItems().get(0).getValue());
                break;
            case 2:
                System.out.println("Using Mana Potion: Restores 10 mana");
                // Add actual effect logic here
                break;
            case 3:
                System.out.println("Using Ethereal Elixir: Restores 100 health and mana");
                // Add actual effect logic here
                break;
            case 4:
                System.out.println("Using Phoenix Feather: Revives with full health");
                // Add actual effect logic here
                break;
            case 5:
                System.out.println("Using Orb of Enlightenment");
                break;
            default:
                System.out.println("Unknown item ID: " + itemID);
                break;
        }
    }

    public void weapons() {
        System.out.println("\n<--- Weapons --->");
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + weapons.get(i).getName() + " || "
                    + weapons.get(i).getDescription() + " || "
                    + weapons.get(i).getAttackBoost() + " Attack");
        }
        System.out.println("[1] Equip Weapon");
        System.out.println("[0] Return");
        System.out.print("Choose: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1 ->
                equipWeapon();
            case 0 ->
                inventory();
        }
    }

    public void equipWeapon() {
        if (weapons.isEmpty()) {
            System.out.println("No weapons available.");
        } else {
            System.out.println("\n<--- Weapons --->");
            for (int i = 0; i < weapons.size(); i++) {
                System.out.println(
                        (i + 1) + ". " + weapons.get(i).getName() + " || "
                        + weapons.get(i).getDescription() + " || "
                        + weapons.get(i).getAttackBoost() + " Attack");
            }
            System.out.print("Choose: ");
            int choice = scan.nextInt();
            weapons.add(player.getWeapon());
            player.setWeapon(weapons.get(choice - 1));
            weapons.remove(choice - 1);
            player.setAttack(player.getAttack() + weapons.get(choice - 1).getAttackBoost());
        }
    }

    public void armors() {
        System.out.println("\n<--- Armor --->");
        for (int i = 0; i < armors.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + armors.get(i).getName() + " || "
                    + armors.get(i).getDescription() + " || "
                    + armors.get(i).getDefenseBoost() + " Defense" + " || "
                    + armors.get(i).getHealthBoost() + " Health");
        }
        System.out.println("[1] Equip Armor");
        System.out.println("[0] Return");
        System.out.print("Choose: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1 ->
                equipArmor();
            case 0 ->
                inventory();
        }
    }

    public void equipArmor() {
        if (armors.isEmpty()) {
            System.out.println("No armors available.");
        } else {
            System.out.println("\n<--- Armor --->");
            for (int i = 0; i < armors.size(); i++) {
                System.out.println(
                        (i + 1) + ". " + armors.get(i).getName() + " || "
                        + armors.get(i).getDescription()
                        + " || " + armors.get(i).getDefenseBoost() + " Defense" + " || "
                        + armors.get(i).getHealthBoost() + " Health");
            }
            System.out.print("Choose: ");
            int choice = scan.nextInt();
            armors.add(player.getArmor());
            player.setArmor(armors.get(choice - 1));
            armors.remove(choice - 1);
            player.setDefense(player.getDefense() + armors.get(choice - 1).getDefenseBoost());
            player.setHealth(player.getHealth() + armors.get(choice - 1).getHealthBoost());
        }
    }

    public void abilities() {
        if (abilities.isEmpty()) {
            System.out.println("\n<--- Abilities --->");
            System.out.println("No abilities available.");
        } else {
            System.out.println("\n<--- Abilities --->");
            for (int i = 0; i < abilities.size(); i++) {
                System.out.println((i + 1) + ". " + abilities.get(i).getName());
            }
        }
    }

    public void stats() {
        System.out.println("\n<--- " + player.getName() + "'s Stats --->");
        System.out.println("Level: " + player.getLevel());
        System.out.println("Exp: " + player.getExp());
        System.out.println("Health: " + player.getHealth());
        System.out.println("Attack: " + player.getAttack());
        System.out.println("Defense: " + player.getDefense());
        System.out.println("Gold: " + player.getGold());
        System.out.println("Weapon: " + player.getWeapon().getName());
        System.out.println("Armor: " + player.getArmor().getName());
    }

    public void saveGame() {
        try {
            FileOutputStream fileOut = new FileOutputStream("savegame.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(player);
            out.writeObject(populate);
            out.close();
            fileOut.close();
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    public void loadGame() {
        try {
            FileInputStream fileIn = new FileInputStream("savegame.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            player = (Player) in.readObject();
            populate = (Populate) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Game loaded successfully.");
            mainMenu();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Game save not found.");
            System.out.println();
            start();
        }
    }

    public void exitGame() {
        saveGame();
        System.out.println("Farewell Warrior...");
        System.exit(0);
    }
}
