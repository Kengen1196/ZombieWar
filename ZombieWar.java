package ZombieWar;

import java.util.Random;
import java.util.Scanner;

public class ZombieWar {
    private BattleManager currentBattle;
    public Group faction1;
    public Group faction2;
    Random rand = new Random();

    public void menu() {
        System.out.println("Please select your options.\n 1)Start Game");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                currentBattle = doZombieWar();
                currentBattle.play();
        }
        input.close();
    }

    private BattleManager doZombieWar() {
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