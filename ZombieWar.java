package ZombieWar;

import java.util.Random;
import java.util.Scanner;

public class ZombieWar {
    private BattleManager currentBattle;
    public Group faction1;
    public Group faction2;
    Random rand = new Random();

    /**
     * A menu to navigate the ZombieWar game choices. User may start run of
     * ZombieWar, Display a description of the game, or exit. Will prompt for
     * valid entry if unable to decipher user selection.
     * 
     * For Release 3 Added Combatant and Weapon Statistics menu options
     */
    public void menu() {
        boolean useMenu = true;
        Scanner input = new Scanner(System.in);

        while (useMenu) {
            System.out.print("\nSelect your option."
                    + "\n 1)Start Game"
                    + "\n 2)Game Description"
                    + "\n 3)Combatant Stats"
                    + "\n 4)Weapon Stats"
                    + "\n 5)Exit\n");

            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    // creates an instance of the battle manager
                    currentBattle = doZombieWar();
                    // plays the game
                    currentBattle.play();
                    break;
                case "2":
                    // Display Brief description of game
                    System.out.println("\nZombieWar\n"
                            + "\n"
                            + "In this brief simulation of a human/zombie war, \n"
                            + "two factions--one of dauntless human fighters, one \n"
                            + "of shambling zombies--do battle to see who will prevail."
                            + "\n\n"
                            + "Who will make it to the other side?\n");
                    break;
                case "3":
                    // Display description and stats of Combatant types
                    System.out.println("Human Combatants:\n");
                    System.out.println("** Mercenary       **   Starting health: 100   Attack: 10");
                    System.out.println("** Newbie          **   Starting health: 20    Attack: 2");
                    System.out.println("** Soldier         **   Starting health: 50    Attack: 5");
                    System.out.println();
                    System.out.println("Zombie Combatants:\n");
                    System.out.println("** Common Infected **   Starting health: 30    Attack: 5");
                    System.out.println("** Tank            **   Starting health: 150   Attack: 20");
                    break;
                case "4":
                    // Display description and stats of Weapons
                    System.out.println("Weapon Statistics:\n");
                    System.out.println("** Assault Rifle  **   Accuracy Rating: 80   Attack: 3");
                    System.out.println("** Axe            **   Accuracy Rating: 90   Attack: 6");                    
                    System.out.println("** Crowbar        **   Accuracy Rating: 80   Attack: 4");
                    System.out.println("** Frying Pan     **   Accuracy Rating: 80   Attack: 2");
                    System.out.println("** Hands          **   Accuracy Rating: 80   Attack: 0");
                    System.out.println("** Mouth          **   Accuracy Rating: 80   Attack: 0");
                    System.out.println("** Pistol         **   Accuracy Rating: 70   Attack: 2");
                    System.out.println("** Shotgun        **   Accuracy Rating: 60   Attack: 6");
                    System.out.println("** Submachine Gun **   Accuracy Rating: 45   Attack: 2");
                    System.out.println();
                    break;
                case "5":
                    // Exit game
                    System.out.println("Thank you for playing the ZombieWar."
                            + "\nTake care of your brains.");
                    useMenu = false;
                    break;
                default:
                    // invalid input from user, display menu again
                    System.out.println("Please select an option from the list.");
                    break;
            }

        }
        input.close();

    }

    // generates and instance of the battle manager and generates the factions
    private BattleManager doZombieWar() {
        // flavor to decide which group attacks first
        int group1 = rand.nextInt(2);
        if (group1 == 0) {
            faction1 = generateHumanGroup();
            faction2 = generateZombieGroup();
        } else {
            faction1 = generateZombieGroup();
            faction2 = generateHumanGroup();
        }
        return new BattleManager(faction1, faction2);

    }

    // generates the factions
    private Group generateHumanGroup() {
        return new Group(0);
    }

    private Group generateZombieGroup() {
        return new Group(1);
    }

    public static void main(String[] args) {
        ZombieWar game = new ZombieWar();
        game.menu();
    }
}