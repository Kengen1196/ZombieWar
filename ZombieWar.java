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
     */
    public void menu() {
        boolean useMenu = true;
        Scanner input = new Scanner(System.in);
        
        while (useMenu) {
            System.out.print("\nSelect your option."
                + "\n 1)Start Game"
                + "\n 2)Game Description"
                + "\n 3)Exit\n");
            
            
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