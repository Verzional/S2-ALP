package Spirit;

import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);
    Character chara;

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
                exit();
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

        chara = new Character(name, 1, 0, 100, 10, 5);
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

    }

    public void inventory() {
        System.out.println("<--- " + chara.name + "'s Inventory --->");
    }

    public void quests() {
        System.out.println("<--- Quests --->");
    }

    public void abilities() {
        System.out.println("<--- " + chara.name + "'s Abilities --->");
    }

    public void stats() {

    }

    public void saveGame() {

    }

    public void exitGame() {

    }

    public void exit() {
        System.out.println("Farewell Warrior...");
        System.exit(0);
    }
}
