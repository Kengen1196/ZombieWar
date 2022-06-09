package ZombieWar;

import java.util.Random;
import java.util.Scanner;

public class ZombieWar {
    private BattleManager currentBattle;
    public Group faction1;
    public Group faction2;
    Random rand = new Random();

    // A menu with currently 1 choice to select from
    public void menu() {
        System.out.println("Please select your options.\n 1)Start Game");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                // creates an instance of the battle manager
                currentBattle = doZombieWar();
                // plays the game
                currentBattle.play();
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

    // generates the factiosn
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