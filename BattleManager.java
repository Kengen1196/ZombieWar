package ZombieWar;

import java.util.Random;

public class BattleManager {
    private Group faction1;
    private Group faction2;
    private Random random = new Random();

    public BattleManager(Group faction1, Group faction2) {
        this.faction1 = faction1;
        this.faction2 = faction2;
    }

    public void play() {
        // Opening message of the game based on whichever faction is faction1
        if (faction1.getFaction() == 0) {
            System.out.println("We have " + faction1.getAlive() + " survivors trying to make it to safety "
                    + faction1.getCombatants());
            System.out.println(
                    "But there are " + faction2.getAlive() + " zombies waiting for them " + faction2.getCombatants());
        } else {
            System.out.println("We have " + faction2.getAlive() + " survivors trying to make it to safety"
                    + faction2.getCombatants());
            System.out.println(
                    "But there are " + faction1.getAlive() + " zombies waiting for them" + faction1.getCombatants());
        }
        // Prints the end result and simulates the game
        System.out.println(getBattleResults());
    }

    // Used to simulate the game and print the results at the end of it
    public String getBattleResults() {
        // As long as both factions are not empty the game will continue playing
        while (faction1.getAlive() > 0 && faction2.getAlive() > 0) {
            this.doTurn();
        }
        // Messages based on whatever faction won and whoever went first
        if (faction1.getAlive() == 0) {
            if (faction1.getFaction() == 0) {
                return "None of the survivors made it.";
            } else {
                return "It seems " + faction2.getAlive() + " survivors have made it to safety";
            }
        } else {
            if (faction2.getFaction() == 0) {
                return "None of the survivors made it.";
            } else {
                return "It seems " + faction1.getAlive() + " have made it to safety";
            }
        }
    }

    // Every turn is simulated in half turns flipping between each faction
    private void doTurn() {
        if (faction2.getAlive() > 0) {
            doHalfTurn(faction1, faction2);
        }
        if (faction1.getAlive() > 0) {
            doHalfTurn(faction2, faction1);
        }
    }

    // Each half turn has an attacker and a defender
    private void doHalfTurn(Group attacker, Group defender) {
        // An attacker and a defender will always be chosen at random and the defender
        // takes damage
        /*
         * Need to handle if there are no more attackers remaining. Check to see
         * if there are any left
         */
        if (attacker.getNumFighters() > 0) {
            int attackerPos = random.nextInt(attacker.getAlive());
            int defenderPos = random.nextInt(defender.getAlive());
            attacker.getFighter(attackerPos).attacks(defender.getFighter(defenderPos));
            // If defender dies then it is moved into the deceased array.
            if (defender.getFighter(defenderPos).isDead() == true) {
                // Prints a message of what attacker killed what defender
                System.out.println(attacker.getFighter(attackerPos).getName() + " killed "
                        + defender.getFighter(defenderPos).getName());
                defender.moveKilled(defenderPos);
            } 
        }
    }
}
