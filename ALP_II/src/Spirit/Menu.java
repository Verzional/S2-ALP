package Spirit;

import java.util.*;
import java.io.*;

public class Menu {

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    Player player;

    private ArrayList<Items> storeI = new ArrayList<Items>();
    private ArrayList<Items> inItems = new ArrayList<Items>();
    private ArrayList<Weapon> storeW = new ArrayList<Weapon>();
    private ArrayList<Weapon> inWeapon = new ArrayList<Weapon>();
    private ArrayList<Armor> storeA = new ArrayList<Armor>();
    private ArrayList<Armor> inArmor = new ArrayList<Armor>();
    private ArrayList<Enemy> citadel = new ArrayList<Enemy>();
    private ArrayList<Enemy> woods = new ArrayList<Enemy>();
    private ArrayList<Enemy> caverns = new ArrayList<Enemy>();
    private ArrayList<Enemy> peaks = new ArrayList<Enemy>();
    private ArrayList<Enemy> depths = new ArrayList<Enemy>();
    private ArrayList<Enemy> bosses = new ArrayList<Enemy>();
    private ArrayList<Quest> quests = new ArrayList<Quest>();
    private ArrayList<Area> areas = new ArrayList<Area>();
    private ArrayList<Abilities> abilities = new ArrayList<Abilities>();
    private ArrayList<Passive> passives = new ArrayList<Passive>();

    public Menu() {
        createArea();
        createAbility();
        createWeapon();
        createArmor();
        createItems();
        createEnemy();
        createBoss();
        createQuest();
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
                                     You awaken in the ruins of an ancient city,
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

        for (int i = 0; i < storeW.size(); i++) {
            if (storeW.get(i).getName().equals("Wooden Sword")) {
                defaultWeapon = storeW.get(i);
            }
        }

        for (int i = 0; i < storeA.size(); i++) {
            if (storeA.get(i).getName().equals("Leather Armor")) {
                defaultArmor = storeA.get(i);
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
        int enemyIndex = rand.nextInt(citadel.size());
        Enemy enemy = citadel.get(enemyIndex);
        System.out.println("You have encountered a " + enemy.getName() + "!");
        System.out.println("Health: " + enemy.getHealth());
        System.out.println("Attack: " + enemy.getAttack());
        System.out.println("Defense: " + enemy.getDefense());
        System.out.println("Money: " + enemy.getMoney());
        System.out.println("Exp: " + enemy.getExp());
        System.out.println("<--- Actions --->");
        System.out.println("1. Attack");
        System.out.println("2. Ability");
        System.out.println("3. Use Item");
        System.out.println("4. Flee");
        System.out.print("Choose: ");
        int choice = scan.nextInt();
        switch (choice) {
            case 1 -> attack(enemy);
            case 2 -> ability(enemy);
            case 3 -> useItem();
            case 4 -> flee();
        }
    }

    public void attack(Enemy enemy) {
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
                System.out.println("Immortality has its price...");
                mainMenu();
            }
        }
    }

    public void ability(Enemy enemy) {
        System.out.println("<--- Abilities --->");
        for (int i = 0; i < abilities.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + abilities.get(i).getName() + " || " + abilities.get(i).getEffect() + " || "
                            + " || " + abilities.get(i).getRequirement());
        }
        System.out.print("Choose: ");
        int choice = scan.nextInt();
        if (player.getMana() >= abilities.get(choice - 1).getRequirement()) {
            int damage = player.getAttack() + Integer.parseInt(abilities.get(choice - 1).getEffect())
                    - enemy.getDefense();
            if (damage <= 0) {
                damage = 1;
            }
            enemy.setHealth(enemy.getHealth() - damage);
            System.out.println(
                    "You use " + abilities.get(choice - 1).getName() + " on the enemy for " + damage + " damage!");
            player.setMana(player.getMana() - abilities.get(choice - 1).getRequirement());
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
            System.out.println("You don't have enough mana!");
        }
    }

    public void useItem(){
        System.out.println("<--- Items --->");
        for (int i = 0; i < inItems.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + inItems.get(i).getName() + " || " + inItems.get(i).getDescription() + " || "
                            + inItems.get(i).getValue() + " || $" + inItems.get(i).getPrice());
        }
        System.out.println("Choose: ");
        int choice = scan.nextInt();
        if (inItems.get(choice - 1).getValue() == 100) {
            player.setHealth(player.getMaxHealth());
            player.setMana(player.getMaxMana());
            inItems.remove(choice - 1);
        } else if (inItems.get(choice - 1).getValue() == 0) {
            player.setHealth(player.getMaxHealth());
            inItems.remove(choice - 1);
        } else if (inItems.get(choice - 1).getValue() == 50) {
            player.setMana(player.getMaxMana());
            inItems.remove(choice - 1);
        }
    }

    public void useWeapon() {
        System.out.println("<--- Weapons --->");
        for (int i = 0; i < inWeapon.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + inWeapon.get(i).getName() + " || " + inWeapon.get(i).getDescription() + " || "
                            + inWeapon.get(i).getEffect() + " || $" + inWeapon.get(i).getPrice());
        }
        System.out.print("Choose: ");
        int choice = scan.nextInt();
        player.setAttack(inWeapon.get(choice - 1).getAttack());
    }

    public void useArmor() {
        System.out.println("<--- Armors --->");
        for (int i = 0; i < inArmor.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + inArmor.get(i).getName() + " || " + inArmor.get(i).getDescription() + " || "
                            + inArmor.get(i).getEffect() + " || $" + inArmor.get(i).getPrice());
        }
        System.out.print("Choose: ");
        int choice = scan.nextInt();
        player.setDefense(inArmor.get(choice - 1).getDefense());
    }

    public void flee() {
        System.out.println("You have fled from battle!");
    }

    public void shop() {
        System.out.println("<--- Aaron's Shop --->");
        System.out.println("Hello " + player.name + "! Welcome to my Shop!");
        System.out.println("Money: " + player.getMoney());
        System.out.println("""
                <--- Shop --->
                [1] Buy
                [2] Sell
                [0] Return
                """);
        System.out.println("Choose: ");
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
            case 1 -> buyWeapon();
            case 2 -> buyArmor();
            case 3 -> buyItems();
            case 0 -> shop();
        }
    }

    public void buyWeapon() {
        for (int i = 0; i < storeW.size(); i++) {
            System.out
                    .println((i + 1) + ". " + storeW.get(i).getName() + " || " + storeW.get(i).getDescription() + " || "
                            + storeW.get(i).getEffect() + " || $" + storeW.get(i).getPrice());
        }
        System.out.println("Choose: ");
        int choose = scan.nextInt();
        if (player.getMoney() > storeW.get(choose).getPrice()) {
            player.setMoney(player.getMoney() - storeW.get(choose).getPrice());
            inWeapon.add(storeW.get(choose - 1));

        } else if (player.getMoney() < storeW.get(choose).getPrice()) {
            System.out.println("You don't have enough money!");
        }
    }

    public void buyArmor() {
        for (int i = 0; i < storeA.size(); i++) {
            System.out
                    .println((i + 1) + ". " + storeA.get(i).getName() + " || " + storeA.get(i).getDescription() + " || "
                            + storeA.get(i).getEffect() + " || $" + storeA.get(i).getPrice());
        }
        System.out.println("Choose: ");
        int choose = scan.nextInt();
        if (player.getMoney() > storeA.get(choose).getPrice()) {
            player.setMoney(player.getMoney() - storeA.get(choose).getPrice());
            inArmor.add(storeA.get(choose - 1));

        } else if (player.getMoney() < storeA.get(choose).getPrice()) {
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
            case 1 -> sellWeapon();
            case 2 -> sellArmor();
            case 3 -> sellItems();
            case 0 -> shop();
        }
    }

    public void sellWeapon() {
        for (int i = 0; i < storeW.size(); i++) {
            System.out
                    .println((i + 1) + ". " + storeW.get(i).getName() + " || " + storeW.get(i).getDescription() + " || "
                            + storeW.get(i).getEffect() + " || $" + storeW.get(i).getPrice());
        }
        System.out.println("Choose: ");
        int choose = scan.nextInt();
        inWeapon.remove(storeW.get(choose - 1));
        player.setMoney(player.getMoney() + (0.75 * storeW.get(choose).getPrice()));
        System.out.println("You've earned $" + (0.75 * storeW.get(choose).getPrice()));
    }

    public void sellArmor() {
        for (int i = 0; i < storeA.size(); i++) {
            System.out
                    .println((i + 1) + ". " + storeA.get(i).getName() + " || " + storeA.get(i).getDescription() + " || "
                            + storeA.get(i).getEffect() + " || $" + storeA.get(i).getPrice());
        }
        System.out.println("Choose: ");
        int choose = scan.nextInt();
        inArmor.remove(storeA.get(choose - 1));
        player.setMoney(player.getMoney() + (0.75 * storeA.get(choose).getPrice()));
        System.out.println("You've earned $" + (0.75 * storeA.get(choose).getPrice()));
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
            case 1 -> items();
            case 2 -> weapons();
            case 3 -> armors();
            case 0 -> mainMenu();
        }
    }

    public void items() {
        System.out.println("<--- Items --->");
        for (int i = 0; i < inItems.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + inItems.get(i).getName() + " || " + inItems.get(i).getDescription() + " || "
                            + inItems.get(i).getValue() + " || $" + inItems.get(i).getPrice());
        }
        System.out.println("[1] Use Item");
        System.out.println("[0] Return");
        System.out.print("Choose: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1 -> useItem();
            case 0 -> inventory();
        }
    }

    public void weapons() {
        System.out.println("<--- Weapons --->");
        for (int i = 0; i < inWeapon.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + inWeapon.get(i).getName() + " || " + inWeapon.get(i).getDescription() + " || "
                            + inWeapon.get(i).getEffect() + " || $" + inWeapon.get(i).getPrice());
        }
        System.out.println("[1] Equip Weapon");
        System.out.println("[0] Return");
        System.out.print("Choose: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1 -> useWeapon();
            case 0 -> inventory();
        }
    }

    public void armors() {
        System.out.println("<--- Armors --->");
        for (int i = 0; i < inArmor.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + inArmor.get(i).getName() + " || " + inArmor.get(i).getDescription() + " || "
                            + inArmor.get(i).getEffect() + " || $" + inArmor.get(i).getPrice());
        }
        System.out.println("[1] Equip Armor");
        System.out.println("[0] Return");
        System.out.print("Choose: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1 -> useArmor();
            case 0 -> inventory();
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
        // Active Abilities
        abilities.add(new Abilities("Inferno Blast", "Unleash an inferno, engulfing enemies in flames", 0));
        abilities.add(new Abilities("Frost Nova", "Summon a frigid storm, freezing foes in their tracks", 5));
        abilities.add(new Abilities("Stormcaller",
                "Harness the power of thunderstorms, striking enemies with lightning", 10));
        abilities.add(new Abilities("Tectonic Quake",
                "Shatter the earth beneath your enemies, causing seismic devastation", 15));
        abilities
                .add(new Abilities("Tempest Fury", "Summon a tempest, tearing apart enemies with ferocious winds", 20));
        abilities
                .add(new Abilities("Shadowstep", "Fade into the shadows, swiftly reappearing behind your enemies", 25));
        abilities.add(new Abilities("Ethereal Barrier", "Weave an ethereal barrier, shielding you from harm", 30));
        abilities.add(
                new Abilities("Dragon's Roar", "Unleash the primal roar of a dragon, paralyzing foes with fear", 35));
        abilities.add(new Abilities("Soul Siphon",
                "Draw upon the life force of enemies, replenishing your own vitality", 40));
        abilities.add(new Abilities("Temporal Shift",
                "Bend time to your will, altering the flow of combat in your favor", 45));

        // Passive Abilities
        passives.add(new Passive("Arcane Affinity", "Augments the potency of arcane spells and abilities", 50, true));
        passives
                .add(new Passive("Shadow Cloak", "Conceals you within the shadows, granting enhanced stealth", 55,
                        true));
        passives.add(new Passive("Titan's Resilience",
                "Endows you with the resilience of titans, reducing damage taken", 60, true));
        passives.add(new Passive("Divine Intervention",
                "Calls upon divine protection, granting occasional healing in dire moments", 65, true));
        passives.add(
                new Passive("Blade Dancer", "Hones your agility and reflexes, granting increased evasion", 70, true));
    }

    public void createWeapon() {
        storeW.add(new Weapon("Elven Longbow", "A masterfully crafted longbow of elven design", 1,
                "Increases critical hit chance", 30, 150));
        storeW.add(new Weapon("Dwarven Warhammer", "A massive warhammer forged in dwarven halls", 5,
                "Chance to stun enemies", 40, 200));
        storeW.add(new Weapon("Stormcaller Staff", "A staff imbued with the power of thunderstorms", 10,
                "Unleashes lightning strikes on enemies", 50, 250));
        storeW.add(new Weapon("Flamebrand Katana", "A katana enchanted with the essence of fire", 15,
                "Deals additional fire damage", 60, 300));
        storeW.add(new Weapon("Soulreaper Scythe", "A grim scythe that reaps souls with every swing", 20,
                "Steals health from enemies", 70, 350));
        storeW.add(new Weapon("Frostbite Axe", "An axe forged in the heart of a blizzard", 25,
                "Chance to freeze enemies", 80, 400));
        storeW.add(new Weapon("Venomous Dagger", "A dagger coated in deadly venom", 30,
                "Applies poison effect to enemies", 90, 450));
        storeW.add(new Weapon("Celestial Staff", "A staff infused with celestial energies", 35,
                "Heals allies and damages enemies", 100, 500));
        storeW.add(new Weapon("Voidblade Saber", "A saber crafted from the essence of the void", 40,
                "Drains enemy's energy on hit", 110, 550));
        storeW.add(new Weapon("Arcane Wand", "A wand crackling with arcane power", 45,
                "Unleashes arcane spells on foes", 120, 600));
    }

    public void createArmor() {
        storeA.add(new Armor("Shadowweave Vestments", "Dark vestments woven from shadowy threads", 1,
                "Grants stealth in dim light", 0, 50, 150));
        storeA.add(new Armor("Stormforged Mail", "Mail armor forged in the heart of a raging storm", 5,
                "Resistant to lightning damage", 0, 100, 250));
        storeA.add(new Armor("Mithril Plate", "Durable plate armor crafted from rare mithril", 10,
                "Increases movement speed", 0, 150, 350));
        storeA.add(new Armor("Phoenix Guard", "Armor infused with the essence of a phoenix", 15,
                "Provides fire immunity for a short duration", 0, 200, 450));
        storeA.add(new Armor("Dragonscale Hauberk", "Hauberk made from the scales of a legendary dragon", 20,
                "Grants dragon-like resilience", 0, 250, 550));
        storeA.add(new Armor("Elven Silk Robes", "Exquisite robes made from enchanted elven silk", 25,
                "Enhanced agility", 0, 250, 600));
        storeA.add(new Armor("Dragon Scale Armor", "Armor crafted from the scales of a slain dragon", 30,
                "Fire resistance", 0, 300, 700));
        storeA.add(
                new Armor("Celestial Plate", "Armor infused with celestial energy", 35, "Celestial Aura", 0, 350, 800));
        storeA.add(new Armor("Shadow Cloak", "Cloak that grants invisibility in shadows", 40,
                "Invisibility in darkness", 0, 400, 900));
        storeA.add(new Armor("Titanium Warplate", "Imposing warplate forged from rare titanium", 45,
                "Increased defense", 0, 450, 1000));
    }

    public void createItems() {
        storeI.add(new Items("Ethereal Elixir", "Infused with ethereal energy, restores 100 health and mana", 100, 100));
        storeI.add(new Items("Phoenix Feather", "Harnesses the essence of the mythical phoenix, reviving you with full health", 0, 200));
        storeI.add(new Items("Potion of Elemental Resistance", "Grants temporary resistance against elemental attacks", 0, 75));
        storeI.add(new Items("Scroll of Teleportation", "Allows instantaneous teleportation to a previously visited location", 0, 150));
        storeI.add(new Items("Crystal of Clarity", "Clears the mind of confusion and restores 50 mana", 50, 75));
        storeI.add(new Items("Amulet of Fortune", "Bestows luck upon the wearer, increasing chance of finding rare loot", 0, 100));
        storeI.add(new Items("Vial of Shadows", "Cloaks the user in shadows, granting temporary invisibility", 0, 100));
        storeI.add(new Items("Basilisk Blood", "Confers the petrifying gaze of a basilisk, paralyzing enemies", 0, 75));
        storeI.add(new Items("Orb of Enlightenment", "Reveals hidden knowledge, granting experience points", 0, 200));
        storeI.add(new Items("Chalice of Renewal", "Renews vitality and strength, restoring 75 health and mana", 75, 100));
    }

    public void createEnemy() {
        citadel.add(new Enemy("Bonecrusher Warrior", 1, 0, 50, 50, 10, 5, 50,
                new Weapon("Bone Axe", "A powerful axe made from bone", 10, "Cripple", 100, 100),
                new Armor("Bone Armor", "Armor crafted from sturdy bones", 5, "Bone Shield", 100, 100, 100)));

        citadel.add(new Enemy("Cursed Phantom Prince", 2, 0, 150, 150, 30, 15, 150,
                new Weapon("Phantom Blade", "A spectral blade that curses its victims", 20, "Curse", 100, 100),
                new Armor("Phantom Cloak", "Cloak that renders the wearer ethereal", 10, "Ethereal Defense", 100, 100,
                        100)));

        citadel.add(new Enemy("Necroshade Princess", 3, 0, 150, 150, 30, 15, 150,
                new Weapon("Necro Staff", "Staff imbued with life-draining magic", 25, "Life Drain", 100, 100),
                new Armor("Shade Robe", "Robe that offers protection against shadows", 12, "Shadow Protection", 100,
                        100, 100)));

        citadel.add(new Enemy("Titan of Shadows", 4, 0, 200, 200, 40, 20, 200,
                new Weapon("Shadow Hammer", "Massive hammer that stuns enemies with darkness", 35, "Stun", 100, 100),
                new Armor("Titan Armor", "Heavy armor with shadow-infused shield", 20, "Shadow Shield", 100, 100,
                        100)));

        woods.add(new Enemy("Direbane Wolf", 6, 0, 300, 300, 40, 20, 300,
                new Weapon("Dire Fangs", "Sharp fangs that cause bleeding", 30, "Bleed", 100, 100),
                new Armor("Wolf Pelt", "Pelt providing evasion against attacks", 15, "Evasion", 100, 100, 100)));

        woods.add(new Enemy("Spectral Wraith", 7, 0, 400, 400, 50, 25, 400,
                new Weapon("Wraith Claws", "Claws that inflict fear in enemies", 35, "Fear", 100, 100),
                new Armor("Spectral Veil", "Veil granting incorporeal protection", 20, "Incorporeal", 100, 100, 100)));

        woods.add(new Enemy("Ethereal Forest Spirit", 8, 0, 500, 500, 60, 30, 500,
                new Weapon("Spirit Branch", "Branch with entangling properties", 40, "Entangle", 100, 100),
                new Armor("Forest Essence", "Essence providing regeneration", 25, "Regeneration", 100, 100, 100)));

        woods.add(new Enemy("Duskblade Elf", 9, 0, 500, 500, 60, 30, 500,
                new Weapon("Duskblade", "Blade coated with poison", 45, "Poison", 100, 100),
                new Armor("Elven Armor", "Armor enhancing agility", 30, "Agility", 100, 100, 100)));

        caverns.add(new Enemy("Goblin Warlock", 11, 0, 600, 600, 60, 30, 600,
                new Weapon("Warlock Staff", "Staff imbued with hexing magic", 50, "Hex", 100, 100),
                new Armor("Goblin Robes", "Robes providing magic resistance", 35, "Magic Resistance", 100, 100,
                        100)));

        caverns.add(new Enemy("Ogre Mauler", 12, 0, 500, 500, 50, 25, 500,
                new Weapon("Maul", "Heavy maul for crushing foes", 55, "Crush", 100, 100),
                new Armor("Ogre Hide", "Thick hide providing toughness", 40, "Toughness", 100, 100, 100)));

        caverns.add(new Enemy("Orc Overlord", 13, 0, 700, 700, 70, 35, 700,
                new Weapon("Overlord Axe", "Massive axe wielded by orc overlords", 60, "Berserk", 100, 100),
                new Armor("Orc Plate", "Plate armor enhancing strength", 45, "Strength", 100, 100, 100)));

        caverns.add(new Enemy("Troll Ravager", 14, 0, 800, 800, 80, 40, 800,
                new Weapon("Ravager Club", "Club used by trolls for smashing", 65, "Smash", 100, 100),
                new Armor("Troll Armor", "Armor providing regeneration", 50, "Regeneration", 100, 100, 100)));

        peaks.add(new Enemy("Frostfire Wyvern", 16, 0, 900, 900, 80, 40, 900,
                new Weapon("Frostfire Breath", "Freezes and burns enemies", 70, "Burn & Freeze", 100, 100),
                new Armor("Wyvern Scales", "Scales providing elemental resistance", 55, "Elemental Resistance", 100,
                        100, 100)));

        peaks.add(new Enemy("Glacial Dragon", 16, 0, 900, 900, 80, 40, 900,
                new Weapon("Glacial Claws", "Claws with freezing power", 75, "Freeze", 100, 100),
                new Armor("Dragonhide", "Tough hide with frost aura", 60, "Frost Aura", 100, 100, 100)));

        peaks.add(new Enemy("Inferno Elemental", 17, 0, 1000, 1000, 90, 45, 1000,
                new Weapon("Inferno Flame", "Flames that engulf and burn", 80, "Burn", 100, 100),
                new Armor("Flame Core", "Core emitting a shield of fire", 65, "Fire Shield", 100, 100, 100)));

        peaks.add(new Enemy("Earthshatter Golem", 18, 0, 1100, 1100, 100, 50, 1100,
                new Weapon("Earthshatter Fist", "Fist causing seismic shockwaves", 85, "Stun", 100, 100),
                new Armor("Golem Stone", "Stone with an earth-shielding property", 70, "Earth Shield", 100, 100, 100)));

        depths.add(new Enemy("Abyssal Nightmare", 21, 0, 1200, 1200, 100, 50, 1200,
                new Weapon("Nightmare Scythe", "Scythe inducing fear", 90, "Fear", 100, 100),
                new Armor("Abyssal Shroud", "Shroud emitting darkness aura", 75, "Darkness Aura", 100, 1000, 100)));

        depths.add(new Enemy("Voidshade Demon", 22, 0, 1300, 1300, 110, 55, 1300,
                new Weapon("Void Claws", "Claws draining life force", 95, "Void Drain", 100, 100),
                new Armor("Void Armor", "Armor providing shielding from void", 80, "Void Shield", 100, 100, 100)));

        depths.add(new Enemy("Soul Devourer", 23, 0, 1400, 1400, 120, 60, 1400,
                new Weapon("Soul Reaver", "Reaver absorbing souls", 100, "Soul Drain", 100, 100),
                new Armor("Devourer Armor", "Armor with life-stealing properties", 85, "Life Steal", 100, 100, 100)));

        depths.add(new Enemy("Cataclysm Bringer", 24, 0, 1500, 1500, 130, 65, 1500,
                new Weapon("Cataclysm Blade", "Blade bringing destruction", 105, "Destruction", 100, 100),
                new Armor("Cataclysm Plate", "Plate emitting cataclysmic aura", 90, "Cataclysm Aura", 100, 100, 100)));
    }

    public void createBoss() {
        bosses.add(new Enemy("The Dark Knight", 5, 0, 1500, 1500, 60, 30, 1500,
                new Weapon("Dark Sword", "Sword that slashes through darkness", 100, "Darkness Slash", 100, 100),
                new Armor("Knight's Armor", "Armor worn by the legendary dark knight", 50, "Shadow Shield", 100, 100,
                        100)));

        bosses.add(new Enemy("Lunar Werewolf", 10, 0, 2000, 2000, 70, 35, 2000,
                new Weapon("Lunar Claws", "Claws imbued with the power of the moon", 110, "Moonlight Slash", 100, 100),
                new Armor("Werewolf Fur", "Fur that grants lunar regeneration", 60, "Lunar Regeneration", 100, 100,
                        100)));

        bosses.add(new Enemy("Chthonic Dreadlord", 15, 0, 2500, 2500, 80, 40, 2500,
                new Weapon("Dread Scythe", "Scythe that instills dread in its victims", 120, "Dread Slash", 100, 100),
                new Armor("Dreadlord's Plate", "Plate armor with dread-infused aura", 70, "Dread Aura", 100, 100,
                        100)));

        bosses.add(new Enemy("Thunderclap Serpent", 20, 0, 3000, 3000, 90, 45, 3000,
                new Weapon("Thunder Fang", "Fangs that summon thunderstorms", 130, "Lightning Strike", 100, 100),
                new Armor("Serpent Scales", "Scales with electrically charged shield", 80, "Electric Shield", 100, 100,
                        100)));

        bosses.add(new Enemy("The Undead Slayer", 25, 0, 3500, 3500, 100, 50, 4000,
                new Weapon("Slayer's Blade", "Blade that banishes undead spirits", 140, "Undead Bane", 100, 100),
                new Armor("Slayer's Armor", "Armor with holy aura to repel undead", 90, "Holy Aura", 100, 100, 100)));
    }

    public void createQuest(){
        quests.add(new Quest("The Lost Artifact", "Retrieve the ancient artifact hidden within the citadel", 5, 1, 100, false));
        quests.add(new Quest("The Cursed Relic", "Destroy the cursed relic that haunts the whispering woods", 10, 2, 200, false));
        quests.add(new Quest("The Dark Ritual", "Stop the dark ritual being performed in the cursed caverns", 15, 3, 300, false));
        quests.add(new Quest("The Shadowed Tome", "Recover the shadowed tome from the shadowed peaks", 20, 4, 400, false));
        quests.add(new Quest("The Abyssal Gate", "Close the abyssal gate that leads to the abyssal depths", 25, 5, 500, false));
    }
}
