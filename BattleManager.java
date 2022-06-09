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
        if (faction1.getFaction() == 0) {
            System.out.println("We have " + faction1.getAlive() + " survivors trying to make it to safety");
            System.out.println("But there are " + faction2.getAlive() + " zombies waiting for them");
        } else {
            System.out.println("We have " + faction2.getAlive() + " survivors trying to make it to safety");
            System.out.println("But there are " + faction1.getAlive() + " zombies waiting for them");
        }
        System.out.println(getBattleResults());
    }

    public String getBattleResults() {
        while (faction1.getAlive() > 0 && faction2.getAlive() > 0) {
            this.doTurn();
        }
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

    private void doTurn() {
        if (faction2.getAlive() > 0) {
            doHalfTurn(faction1, faction2);
        }
        if (faction1.getAlive() > 0) {
            doHalfTurn(faction2, faction1);
        }
    }

    private void doHalfTurn(Group attacker, Group defender) {
        int attackerPos = random.nextInt(attacker.getAlive());
        int defenderPos = random.nextInt(defender.getAlive());
        attacker.getFighter(attackerPos).attacks(defender.getFighter(defenderPos));
        if (defender.getFighter(defenderPos).isDead() == true) {
            defender.moveKilled(defenderPos);
        }
    }
}
