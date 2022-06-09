package ZombieWar;

import java.util.ArrayList;
import java.util.Random;

public class Group {
    private ArrayList<Combatant> fighters = new ArrayList<Combatant>();
    private ArrayList<Combatant> deadFighters = new ArrayList<Combatant>();

    private Random rand = new Random();
    private int numCombatants;
    private int faction;

    public Group(int faction) {
        this.faction = faction;
        int choice;
        numCombatants = rand.nextInt(10) + 1;

        if (faction == 0) {
            int numSoldiers = 0;
            int numMercenary = 0;
            int numNewbies = 0;
            for (int x = 0; x < numCombatants; x++) {
                choice = rand.nextInt(3);
                switch (choice) {
                    case 0:
                        fighters.add(new Newbie());
                        numNewbies++;

                    case 1:
                        fighters.add(new Mercenary());
                        numMercenary++;

                    case 2:
                        fighters.add(new Soldier());
                        numSoldiers++;
                }
            }
        } else {
            int numCommon = 0;
            int numTanks = 0;

            for (int x = 0; x < numCombatants; x++) {
                choice = rand.nextInt(2);
                switch (choice) {
                    case 0:
                        fighters.add(new Common());
                        numCommon++;
                    case 1:
                        fighters.add(new Tank());
                        numTanks++;
                }
            }
        }

    }

    public void moveKilled(int combatant) {
        deadFighters.add(fighters.remove(combatant));
    }

    public int getAlive() {
        return fighters.size();
    }

    public int getDead() {
        return deadFighters.size();
    }

    public Combatant getFighter(int i) {
        return fighters.get(i);
    }

    public Combatant getDeadFighter(int i) {
        return deadFighters.get(i);
    }

    public int getFaction() {
        return faction;
    }
}
