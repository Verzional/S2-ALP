package EOTFK;

import java.util.*;
import java.io.*;

public class Menu {

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    Player player;
    Populate populate;

    private final LinkedList<Items> items = new LinkedList<>();
    private final LinkedList<Abilities> abilities = new LinkedList<>();
    private final LinkedList<Weapon> weapons = new LinkedList<>();
    private final LinkedList<Armor> armors = new LinkedList<>();

    public Menu() {
        populate = new Populate();
        populateGame();
        populateItem();
    }

    private void populateGame() {
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

    private void populateItem() {
        for (int i = 0; i < 5; i++) {
            items.addFirst(populate.getStoreItems().get(0));
            items.addFirst(populate.getStoreItems().get(1));
        }
        abilities.addFirst(populate.getAbilities().get(0));
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
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void prologue() {
        System.out.println(
                """
                        <--------------------------------------------------------------------------------------->
                                                You awaken in the ruins of an ancient city,
                                         devoid of memories but burdened with a sense of purpose.
                        Guided by whispers from the past, you set forth on a quest to reclaim your lost humanity,
                                           and unearth the truth behind the kingdom's downfall.
                        <--------------------------------------------------------------------------------------->
                                                        """);
        System.out.print("What is your name immortal one?\n");
        System.out.print("Name: ");
        String name = scan.next() + scan.nextLine();

        player = new Player(name, 1, 0, 50, 50, 20, 20, 20, 10, 50,
                new Weapon("Wooden Sword", "A Normal Wooden Sword", 1, 1, 0, 10),
                new Armor("Leather Armor", "A Normal Leather Armor", 1,
                        1, 0, 5, 5));
        mainMenu();
    }

    private void mainMenu() {
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
            } catch (Exception e) {
                System.out.println("Please choose a valid option!");
            }
        } while (true);
    }

    private void travel() {
        try {
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
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void battle(int areaID) {
        int stage = 1;
        do {
            check();

            Enemy enemy = getEnemyForStage(stage, areaID);

            if (stage == 10) {
                System.out.println("\n<--- Final Stage --->");
            } else {
                System.out.println("\n<--- Stage " + stage + " --->");
            }

            while (player.getHealth() > 0 && enemy.getHealth() > 0) {
                displayStageInfo(enemy);
                if (!playerAction(enemy)) {
                    return;
                }
            }

            if (stage == 11) {
                areaCleared(areaID);
                return;
            }
            stage++;
        } while (stage <= 10);
    }

    private void check() {
        if (player.getExp() >= player.getLevel() * 100) {
            player.levelUp();
            System.out.println(player.getName() + " have leveled up!");
        }
        for (Abilities ability : abilities) {
            if (!ability.isUnlocked() && player.getLevel() >= ability.getUnlockLevel()) {
                ability.unlock();
                System.out.println(player.getName() + " have unlocked a new ability!");
                System.out.println(ability.getName() + " has been unlocked!");
                abilities.addFirst(ability);
            }
        }
    }

    private Enemy getEnemyForStage(int stage, int areaID) {
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

        enemy.setAttack(enemy.getAttack() + enemy.getWeapon().getAttackBoost());
        enemy.setDefense(enemy.getDefense() + enemy.getArmor().getDefenseBoost());
        enemy.setMaxHealth(enemy.getMaxHealth() + enemy.getArmor().getHealthBoost()); 
        enemy.setHealth(enemy.getHealth() + enemy.getArmor().getHealthBoost());

        if (stage == 10) {
            enemy = bossEnemy;
        }

        return enemy;
    }

    private void displayStageInfo(Enemy enemy) {
        System.out.println("\n<--- " + enemy.getName() + " -->");
        System.out.println("Level: " + enemy.getLevel());
        System.out.println("Health: " + enemy.getHealth() + " / " + enemy.getMaxHealth());
        System.out.println("Attack: " + enemy.getAttack());
        System.out.println("Defense: " + enemy.getDefense());

        System.out.println("\n<--- Player --->");
        System.out.println("Level: " + player.getLevel());
        System.out.println("Health: " + player.getHealth() + " / " + player.getMaxHealth());
        System.out.println("Mana: " + player.getMana() + " / " + player.getMaxMana());
        System.out.println("Attack: " + player.getAttack());
        System.out.println("Defense: " + player.getDefense());
    }

    private boolean playerAction(Enemy enemy) {
        try {
            System.out.println("\n<--- Actions --->");
            System.out.println("1. Attack");
            System.out.println("2. Use Ability");
            System.out.println("3. Use Item");
            System.out.println("4. Flee");
            System.out.print("Choose: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1 ->
                    attack(enemy);
                case 2 ->
                    useAbility(enemy);
                case 3 -> {
                    useItem();
                    enemyAttack(enemy);
                }
                case 4 -> {
                    System.out.println(player.getName() + " fled from the enemy!");
                    mainMenu();
                    return false;
                }
            }

            if (enemy.getHealth() <= 0) {
                enemyDefeated(enemy);
            } else if (player.getHealth() <= 0) {
                System.out.println("Immortality has its limits...");
                mainMenu();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }

        return true;
    }

    private void attack(Enemy enemy) {
        int playerDamage = player.getAttack() - enemy.getDefense();

        playerDamage = Math.max(playerDamage, 1);

        enemy.setHealth(enemy.getHealth() - playerDamage);

        System.out.println("\n" + player.getName() + " dealt " + playerDamage + " damage to the enemy!");

        enemyAttack(enemy);
    }

    private void enemyAttack(Enemy enemy) {
        if (enemy.getAreaID() == 6) {
            int bossMove;

            if (enemy.getBossID() == 1) {
                bossMove = rand.nextInt(0, 3);
            } else if (enemy.getBossID() == 2) {
                bossMove = rand.nextInt(0, 5);
            } else if (enemy.getBossID() == 3) {
                bossMove = rand.nextInt(0, 7);
            } else if (enemy.getBossID() == 4) {
                bossMove = rand.nextInt(0, 9);
            } else {
                bossMove = rand.nextInt(0, 11);
            }

            switch (bossMove) {
                case 0 -> {
                    int enemyDamage = enemy.getAttack() - player.getDefense();

                    enemyDamage = Math.max(enemyDamage, 1);

                    player.setHealth(player.getHealth() - enemyDamage);

                    System.out.println(
                            enemy.getName() + " dealt " + enemyDamage + " damage to " + player.getName() + "!");
                }

                case 1 -> {
                    System.out.println("\n" + enemy.getName() + " used Inferno Blast!");
                    double infernoDamage = Math.ceil(enemy.getAttack() * 1.25 - player.getDefense());
                    player.setHealth(player.getHealth() - infernoDamage);
                    System.out.println(enemy.getName() + " have dealt " + infernoDamage + " inferno damage!");
                    populate.burnPlayer(player);
                }

                case 2 -> {
                    System.out.println("\n" + enemy.getName() + " used Frost Nova!");
                    double frostDamage = Math.ceil(enemy.getAttack() * 1.25 - player.getDefense());
                    player.setHealth(player.getHealth() - frostDamage);
                    System.out.println(enemy.getName() + " have dealt " + frostDamage + " frost damage!");
                    populate.freeze();
                    if (populate.freeze() == true) {
                        System.out.println(player.getName() + " has been frozen for one turn!");
                        enemyAttack(enemy);
                    } else {
                        scan.nextLine();
                    }
                }

                case 3 -> {
                    System.out.println("\n" + enemy.getName() + " used Stormcaller!");
                    double stormDamage = Math.ceil(enemy.getAttack() * 1.5 - player.getDefense());
                    player.setHealth(player.getHealth() - stormDamage);
                    System.out.println(enemy.getName() + " have dealt " + stormDamage + " storm damage!");
                    populate.paralyze();
                    if (populate.paralyze() == true) {
                        System.out.println(player.getName() + " has been paralyzed for one turn!");
                        enemyAttack(enemy);
                    } else {
                        scan.nextLine();
                    }
                }

                case 4 -> {
                    System.out.println("\n" + enemy.getName() + " used Tectonic Quake!");
                    double stormDamage = Math.ceil(enemy.getAttack() * 1.5 - player.getDefense());
                    player.setHealth(player.getHealth() - stormDamage);
                    System.out.println(enemy.getName() + " have dealt " + stormDamage + " quake damage!");
                    populate.confuse();
                    if (populate.confuse() == true) {
                        System.out.println(player.getName() + " is confused!");
                        playerConfused();
                    } else {
                        scan.nextLine();
                    }
                }

                case 5 -> {
                    System.out.println("\n" + enemy.getName() + " used Glacial Cataclysm!");
                    double glacialDamage = Math.ceil(enemy.getAttack() * 1.75 - player.getDefense());
                    player.setHealth(player.getHealth() - glacialDamage);
                    System.out.println(enemy.getName() + " have dealt " + glacialDamage + " glacial damage!");
                    populate.freeze();
                    if (populate.freeze() == true) {
                        System.out.println(player.getName() + " has been frozen for one turn!");
                        enemyAttack(enemy);
                    } else {
                        scan.nextLine();
                    }
                }

                case 6 -> {
                    System.out.println("\n" + enemy.getName() + " used Shadowstep!");
                    double shadowDamage = Math.ceil(enemy.getAttack() * 1.75 - player.getDefense());
                    player.setHealth(player.getHealth() - shadowDamage);
                    System.out.println(enemy.getName() + " have dealt " + shadowDamage + " shadow damage!");
                    populate.confuse();
                    if (populate.confuse() == true) {
                        System.out.println(player.getName() + " is confused!");
                        playerConfused();
                    } else {
                        scan.nextLine();
                    }
                }

                case 7 -> {
                    System.out.println("\n" + enemy.getName() + " used Scorching Flames!");
                    double flameDamage = Math.ceil(enemy.getAttack() * 2 - player.getDefense());
                    player.setHealth(player.getHealth() - flameDamage);
                    System.out.println(enemy.getName() + " have dealt " + flameDamage + " flame damage!");
                    populate.burnPlayer(player);
                }

                case 8 -> {
                    System.out.println("\n" + enemy.getName() + " used Dragon's Roar!");
                    double roarDamage = Math.ceil(enemy.getAttack() * 2 - player.getDefense());
                    player.setHealth(player.getHealth() - roarDamage);
                    System.out.println(enemy.getName() + " have dealt " + roarDamage + " roar damage!");
                    populate.paralyze();
                    if (populate.paralyze() == true) {
                        System.out.println(player.getName() + " has been paralyzed for one turn!");
                        enemyAttack(enemy);
                    } else {
                        scan.nextLine();
                    }
                }

                case 9 -> {
                    System.out.println("\n" + enemy.getName() + " used Soul Siphon!");
                    double soulDamage = Math.ceil(enemy.getAttack() * 2 - player.getDefense());
                    player.setHealth(player.getHealth() - soulDamage);
                    enemy.setHealth(enemy.getHealth() + soulDamage);
                    System.out.println(
                            enemy.getName() + " have stolen " + soulDamage + " health from " + player.getName() + "!");
                }

                case 10 -> {
                    System.out.println("\n" + enemy.getName() + " used Celestial Wrath!");
                    double wrathDamage = Math.ceil(enemy.getAttack() * 2.5 - player.getDefense());
                    player.setHealth(player.getHealth() - wrathDamage);
                    System.out.println(enemy.getName() + " have awoken the celestial's wrath! " + wrathDamage
                            + " damage has been bestowed upon " + player.getName() + "!");
                }
            }
        } else {
            int enemyDamage = enemy.getAttack() - player.getDefense();

            enemyDamage = Math.max(enemyDamage, 1);

            player.setHealth(player.getHealth() - enemyDamage);

            System.out.println(enemy.getName() + " dealt " + enemyDamage + " damage to " + player.getName() + "!");
        }
    }

    private void useAbility(Enemy enemy) {
        try {
            if (abilities.isEmpty()) {
                System.out.println("\n<--- Ability --->");
                System.out.println("No abilities available.");
            } else {
                System.out.println("\n<--- Abilities --->");
                for (int i = 0; i < abilities.size(); i++) {
                    System.out.println(
                            (i + 1) + ". " + abilities.get(i).getName() + " || " + abilities.get(i).getEffect() + " || "
                                    + abilities.get(i).getManaCost() + " Mana");
                }
                System.out.print("Choose an ability: ");
                int choice = scan.nextInt();

                if (choice < 1 || choice > abilities.size()) {
                    System.out.println("Invalid choice.");
                } else {
                    Abilities selectedAbility = abilities.get(choice - 1);
                    int abilityID = selectedAbility.getAbilityID();
                    applyAbility(enemy, abilityID);
                }
            }
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void applyAbility(Enemy enemy, int abilityID) {
        switch (abilityID) {
            case 1 -> {
                if (player.getMana() < 5) {
                    System.out.println("Not enough mana to cast Inferno Blast!");
                } else {
                    System.out.println("\nInferno Blast!");
                    double infernoDamage = Math.ceil(player.getAttack() * 1.25 - enemy.getDefense());
                    enemy.setHealth(enemy.getHealth() - infernoDamage);
                    System.out.println(player.getName() + " dealt " + infernoDamage + " inferno damage!");
                    player.setMana(player.getMana() - 5);
                    populate.burn(enemy);
                    enemyAttack(enemy);
                }
            }

            case 2 -> {
                if (player.getMana() < 5) {
                    System.out.println("Not enough mana to cast Frost Nova!");
                } else {
                    System.out.println("\nFrost Nova!");
                    double frostDamage = Math.ceil(player.getAttack() * 1.25 - enemy.getDefense());
                    enemy.setHealth(enemy.getHealth() - frostDamage);
                    System.out.println(player.getName() + " dealt " + frostDamage + " frost damage!");
                    player.setMana(player.getMana() - 5);
                    populate.freeze();
                    if (populate.freeze() == true) {
                        System.out.println(enemy.getName() + " has been frozen for one turn!");
                    } else {
                        enemyAttack(enemy);
                    }
                }
            }

            case 3 -> {
                if (player.getMana() < 7) {
                    System.out.println("Not enough mana to cast Stormcaller!");
                } else {
                    System.out.println("\nStormcaller!");
                    double stormDamage = Math.ceil(player.getAttack() * 1.5 - enemy.getDefense());
                    enemy.setHealth(enemy.getHealth() - stormDamage);
                    System.out.println(player.getName() + " dealt " + stormDamage + " storm damage!");
                    player.setMana(player.getMana() - 7);
                    populate.paralyze();
                    if (populate.paralyze() == true) {
                        System.out.println(enemy.getName() + " has been paralyzed for one turn!");
                    } else {
                        enemyAttack(enemy);
                    }
                }
            }

            case 4 -> {
                if (player.getMana() < 7) {
                    System.out.println("Not enough mana to cast Tectonic Quake!");
                } else {
                    System.out.println("\nTectonic Quake!");
                    double quakeDamage = Math.ceil(player.getAttack() * 1.5 - enemy.getDefense());
                    enemy.setHealth(enemy.getHealth() - quakeDamage);
                    System.out.println(player.getName() + " dealt " + quakeDamage + " quake damage!");
                    player.setMana(player.getMana() - 7);
                    populate.confuse();
                    if (populate.confuse() == true) {
                        System.out.println(enemy.getName() + " is confused!");
                        enemyConfused(enemy);
                    } else {
                        enemyAttack(enemy);
                    }
                }
            }

            case 5 -> {
                if (player.getMana() < 10) {
                    System.out.println("Not enough mana to cast Glacial Cataclysm!");
                } else {
                    System.out.println("\nGlacial Cataclysm!");
                    double glacialDamage = Math.ceil(player.getAttack() * 1.75 - enemy.getDefense());
                    enemy.setHealth(enemy.getHealth() - glacialDamage);
                    System.out.println(player.getName() + " dealt " + glacialDamage + " glacial damage!");
                    player.setMana(player.getMana() - 10);
                    populate.freeze();
                    if (populate.freeze() == true) {
                        System.out.println(enemy.getName() + " has been frozen for one turn!");
                    } else {
                        enemyAttack(enemy);
                    }
                }
            }

            case 6 -> {
                if (player.getMana() < 10) {
                    System.out.println("Not enough mana to cast Shadowstep!");
                } else {
                    System.out.println("\nShadowstep!");
                    double shadowDamage = Math.ceil(player.getAttack() * 1.75 - enemy.getDefense());
                    enemy.setHealth(enemy.getHealth() - shadowDamage);
                    System.out.println(player.getName() + " dealt " + shadowDamage + " shadow damage!");
                    player.setMana(player.getMana() - 10);
                    populate.confuse();
                    if (populate.confuse() == true) {
                        System.out.println(enemy.getName() + " is confused!");
                        enemyConfused(enemy);
                    } else {
                        enemyAttack(enemy);
                    }
                }
            }

            case 7 -> {
                if (player.getMana() < 15) {
                    System.out.println("Not enough mana to cast Scorching Flames!");
                } else {
                    System.out.println("\nScorching Flames!");
                    double flameDamage = Math.ceil(player.getAttack() * 2 - enemy.getDefense());
                    enemy.setHealth(enemy.getHealth() - flameDamage);
                    System.out.println(player.getName() + " dealt " + flameDamage + " flame damage!");
                    player.setMana(player.getMana() - 15);
                    populate.burn(enemy);
                    enemyAttack(enemy);
                }
            }

            case 8 -> {
                if (player.getMana() < 15) {
                    System.out.println("Not enough mana to cast Dragon's Roar!");
                } else {
                    System.out.println("\nDragon's Roar!");
                    double roarDamage = Math.ceil(player.getAttack() * 2 - enemy.getDefense());
                    enemy.setHealth(enemy.getHealth() - roarDamage);
                    System.out.println(player.getName() + " dealt " + roarDamage + " roar damage!");
                    player.setMana(player.getMana() - 15);
                    populate.paralyze();
                    if (populate.paralyze() == true) {
                        System.out.println(enemy.getName() + " has been paralyzed for one turn!");
                    } else {
                        enemyAttack(enemy);
                    }
                }
            }

            case 9 -> {
                if (player.getMana() < 20) {
                    System.out.println("Not enough mana to cast Soul Siphon!");
                } else {
                    System.out.println("\nSoul Siphon!");
                    double soulDamage = Math.ceil(player.getAttack() * 2 - enemy.getDefense());
                    enemy.setHealth(enemy.getHealth() - soulDamage);
                    player.setHealth(player.getHealth() + soulDamage);
                    System.out.println(player.getName() + " has stolen " + soulDamage + " health from the enemy!");
                    player.setMana(player.getMana() - 20);
                    enemyAttack(enemy);
                }
            }

            case 10 -> {
                if (player.getMana() < 30) {
                    System.out.println("Not enough mana to cast Celestial Wrath!");
                } else {
                    System.out.println("\nCelestial Wrath!");
                    double wrathDamage = Math.ceil(player.getAttack() * 2.5 - enemy.getDefense());
                    enemy.setHealth(enemy.getHealth() - wrathDamage);
                    System.out.println(player.getName() + " has awoken the celestial's wrath! " + wrathDamage
                            + " damage has been bestowed upon" + enemy.getName() + "!");
                    player.setMana(player.getMana() - 30);
                    enemyAttack(enemy);
                }
            }
        }
    }

    private void enemyConfused(Enemy enemy) {
        int enemyDamage = enemy.getAttack() - enemy.getDefense();

        enemyDamage = Math.max(enemyDamage, 1);

        enemy.setHealth(enemy.getHealth() - enemyDamage);

        System.out.println(enemy.getName() + " dealt " + enemyDamage + " damage to itself!");
    }

    private void playerConfused() {
        int playerDamage = player.getAttack() - player.getDefense();

        playerDamage = Math.max(playerDamage, 1);

        player.setHealth(player.getHealth() - playerDamage);

        System.out.println(player.getName() + " dealt " + playerDamage + " damage to itself!");
    }

    private void enemyDefeated(Enemy enemy) {
        enemy.setHealth(enemy.getMaxHealth());
        enemy.setAttack(enemy.getAttack() - enemy.getWeapon().getAttackBoost());
        enemy.setDefense(enemy.getDefense() - enemy.getArmor().getDefenseBoost());
        enemy.setHealth(enemy.getHealth() - enemy.getArmor().getHealthBoost());
        System.out.println("\n" + enemy.getName() + " has been defeated!");
        player.setGold(player.getGold() + enemy.getGold());
        player.setExp(player.getExp() + enemy.getExp());
        System.out.println(player.getName() + " have gained " + enemy.getExp() + " EXP!");
        System.out.println(player.getName() + " have gained " + enemy.getGold() + " Gold!");
        enemyDropRate(enemy);

        handleContinueOptions();
    }

    private void handleContinueOptions() {
        try {
            System.out.println("""

                    <-------------->
                     [1] Continue
                     [2] Inventory
                     [3] Return
                    """);
            System.out.print("Choose: ");
            int continueChoice = scan.nextInt();

            switch (continueChoice) {
                case 1 -> {
                    // Continue to the next stage
                }
                case 2 ->
                    inventory();
                case 3 ->
                    mainMenu();
            }
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void areaCleared(int areaID) {
        System.out.println("\nArea cleared! " + populate.getAreas().get(areaID - 1).getName() + " has been conquered!");
        populate.getAreas().get(areaID - 1).complete();
        if (populate.getAreas().get(areaID - 1).isCompleted()) {
            player.setExp(player.getExp() + populate.getAreas().get(areaID - 1).getCompletionXP());
            player.setGold(player.getGold() + populate.getAreas().get(areaID - 1).getCompletionGold());
            System.out.println(player.getName() + " have gained "
                    + populate.getAreas().get(areaID - 1).getCompletionXP() + " EXP!");
            System.out.println(player.getName() + " have gained "
                    + populate.getAreas().get(areaID - 1).getCompletionGold() + " Gold!");
        }
        if (populate.getAreas().get(areaID - 1).getAreaID() < populate.getAreas().size()) {
            System.out.println(player.getName() + "  have unlocked the next area!");
            populate.getAreas().get(areaID).unlock();
        } else {
            System.out.println("""
                    <--------------------------------------------------------------------------------------->
                                You have conquered the kingdom and restored balance to the land.
                                  The shadows have been vanquished, and the kingdom is reborn.
                    <--------------------------------------------------------------------------------------->
                    """);
            mainMenu();
        }
    }

    private void enemyDropRate(Enemy enemy) {
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
            default ->
                10;
        };

        int chance = rand.nextInt(100);
        if (chance < dropChance) {
            int itemChance = rand.nextInt(2);
            if (itemChance == 0) {
                Weapon droppedWeapon = enemy.getWeapon();
                weapons.addFirst(droppedWeapon);
                System.out.println("\n" + player.getName() + " have obtained " + droppedWeapon.getName() + "!");
            } else {
                Armor droppedArmor = enemy.getArmor();
                armors.addFirst(droppedArmor);
                System.out.println("\n" + player.getName() + " have obtained " + droppedArmor.getName() + "!");
            }
        }
    }

    private void shop() {
        try {
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
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void buy() {
        try {
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
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void buyWeapon() {
        try {
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
                    weapons.addFirst(populate.getStoreWeapons().get(choose - 1));
                } else if (player.getGold() < populate.getStoreWeapons().get(choose).getCost()) {
                    System.out.println(player.getName() + " doesn't have enough gold!");
                }
            } else {
                System.out.println(player.getName() + " needs to be at least level "
                        + populate.getStoreWeapons().get(choose).getLevelRequirement()
                        + " to buy this.");
            }
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void buyArmor() {
        try {
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
                    armors.addFirst(populate.getStoreArmor().get(choose - 1));
                } else if (player.getGold() < populate.getStoreArmor().get(choose).getCost()) {
                    System.out.println(player.getName() + " doesn't have enough gold!");
                }
            } else {
                System.out.println(player.getName() + " needs to be at least level "
                        + populate.getStoreArmor().get(choose).getLevelRequirement() + " to buy this.");
            }
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void buyItems() {
        try {
            for (int i = 0; i < populate.getStoreItems().size(); i++) {
                System.out.println((i + 1) + ". " + populate.getStoreItems().get(i).getName() + " || "
                        + populate.getStoreItems().get(i).getEffect() + " || $"
                        + populate.getStoreItems().get(i).getCost());
            }
            System.out.print("Choose: ");
            int choose = scan.nextInt();
            if (player.getGold() > populate.getStoreItems().get(choose).getCost()) {
                player.setGold(player.getGold() - populate.getStoreItems().get(choose).getCost());
                items.addFirst(populate.getStoreItems().get(choose - 1));
            } else if (player.getGold() < populate.getStoreItems().get(choose).getCost()) {
                System.out.println(player.getName() + " don't have enough gold!");
            }
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void sell() {
        try {
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
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void sellWeapon() {
        try {
            for (int i = 0; i < weapons.size(); i++) {
                System.out.println((i + 1) + ". " + weapons.get(i).getName() + " || "
                        + weapons.get(i).getDescription() + " || "
                        + weapons.get(i).getAttackBoost() + " Attack");
            }
            System.out.print("Choose: ");
            int choice = scan.nextInt();
            player.setGold(player.getGold() + weapons.get(choice - 1).getCost());
            weapons.remove(choice - 1);
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void sellArmor() {
        try {
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
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void sellItems() {
        try {
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).getName() + " || "
                        + items.get(i).getEffect());
            }
            System.out.print("Choose: ");
            int choice = scan.nextInt();
            player.setGold(player.getGold() + items.get(choice - 1).getCost());
            items.remove(choice - 1);
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void inventory() {
        try {
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
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void items() {
        try {
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
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void useItem() {
        try {
            if (items.isEmpty()) {
                System.out.println("\n<--- Items --->");
                System.out.println("No items available.");
            } else {
                System.out.println("\n<--- Items --->");
                for (int i = 0; i < items.size(); i++) {
                    System.out.println((i + 1) + ". " + items.get(i).getName() + " || " + items.get(i).getEffect());
                }
                System.out.print("Choose an item: ");
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
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void applyEffect(int itemID) {
        switch (itemID) {
            case 1 -> {
                System.out.println("Using Health Potion");
                System.out.println("20 Health Restored");
                player.setHealth(player.getHealth() + 20);
                if (player.getHealth() > player.getMaxHealth()) {
                    player.setHealth(player.getMaxHealth());
                }
            }
            case 2 -> {
                System.out.println("Using Mana Potion");
                System.out.println("10 Mana Restored");
                player.setMana(player.getMana() + 20);
                if (player.getMana() > player.getMaxMana()) {
                    player.setMana(player.getMaxMana());
                }
            }
            case 3 -> {
                System.out.println("Using Ethereal Elixir");
                System.out.println("Restored 100 Health and Mana");
                player.setHealth(player.getHealth() + 100);
                player.setMana(player.getMana() + 100);
                if (player.getHealth() > player.getMaxHealth()) {
                    player.setHealth(player.getMaxHealth());
                }
                if (player.getMana() > player.getMaxMana()) {
                    player.setMana(player.getMaxMana());
                }
            }
            case 4 -> {
                System.out.println("Using Phoenix Feather");
                System.out.println("Your health has been fully restored!");
                player.setHealth(player.getMaxHealth());
            }
            case 5 -> {
                System.out.println("Using Orb of Enlightenment");
                System.out.println("Gained 100 EXP");
                player.setExp(player.getExp() + 100);
                check();
            }
            default ->
                System.out.println("Unknown item ID: " + itemID);
        }
    }

    private void weapons() {
        try {
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
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void equipWeapon() {
        try {
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
                weapons.addFirst(player.getWeapon());
                player.setWeapon(weapons.get(choice - 1));
                weapons.remove(choice - 1);
                player.setAttack(player.getAttack() + weapons.get(choice - 1).getAttackBoost());
            }
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void armors() {
        try {
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
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void equipArmor() {
        try {
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
                armors.addFirst(player.getArmor());
                player.setArmor(armors.get(choice - 1));
                armors.remove(choice - 1);
                player.setDefense(player.getDefense() + armors.get(choice - 1).getDefenseBoost());
                player.setHealth(player.getHealth() + armors.get(choice - 1).getHealthBoost());
            }
        } catch (Exception e) {
            System.out.println("Please choose a valid option!");
        }
    }

    private void abilities() {
        if (abilities.isEmpty()) {
            System.out.println("\n<--- Abilities --->");
            System.out.println("No abilities available.");
        } else {
            System.out.println("\n<--- Abilities --->");
            for (int i = 0; i < abilities.size(); i++) {
                System.out.println((i + 1) + ". " + abilities.get(i).getName() + " || " + abilities.get(i).getEffect()
                        + " || " + abilities.get(i).getManaCost() + " Mana");
            }
        }
    }

    private void stats() {
        System.out.println("\n<--- " + player.getName() + "'s Stats --->");
        System.out.println("Level: " + player.getLevel());
        System.out.println("EXP: " + player.getExp());
        System.out.println("Health: " + player.getHealth() + " / " + player.getMaxHealth());
        System.out.println("Mana: " + player.getMana() + " / " + player.getMaxMana());
        System.out.println("Attack: " + player.getAttack());
        System.out.println("Defense: " + player.getDefense());
        System.out.println("Gold: " + player.getGold());
        System.out.println("Weapon: " + player.getWeapon().getName());
        System.out.println("Armor: " + player.getArmor().getName());
    }

    private void saveGame() {
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

    private void loadGame() {
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

    private void exitGame() {
        saveGame();
        System.out.println("Farewell Warrior...");
        System.exit(0);
    }
}
