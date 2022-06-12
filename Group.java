package ZombieWar;

import java.util.ArrayList;
import java.util.Random;

public class Group {
    // Dynamic ArrayList was used to store nodes of Combatants
    private ArrayList<Combatant> fighters = new ArrayList<Combatant>();
    private ArrayList<Combatant> deadFighters = new ArrayList<Combatant>();
    // Random class was used to decide a random size for the combatants
    private Random rand = new Random();
    private int numCombatants;
    private int faction;
    private int numSoldiers = 0;
    private int numMercenary = 0;
    private int numNewbies = 0;
    private int numCommon = 0;
    private int numTanks = 0;

    // Group initiates based on what the inputted faction 0 for survivors while any
    // other for zombies
    public Group(int faction) {
        this.faction = faction;
        int choice;
        // generates a random amount of combatants. Size is arbritrary to decided by me.
        numCombatants = rand.nextInt(20);

        // Function for generating survivors
        if (faction == 0) {
            // Loops adding a random survivor entity based on random number generated and
            // assigns an id
            for (int x = 0; x < numCombatants; x++) {
                choice = rand.nextInt(3);
                switch (choice) {
                    case 0:
                        fighters.add(new Newbie(numNewbies));
                        numNewbies++;

                    case 1:
                        fighters.add(new Mercenary(numMercenary));
                        numMercenary++;

                    case 2:
                        fighters.add(new Soldier(numSoldiers));
                        numSoldiers++;
                }
            }
            // Zombie generation function
        } else {
            // Loops for zombie entities based on random number generated
            for (int x = 0; x < numCombatants; x++) {
                choice = rand.nextInt(2);
                switch (choice) {
                    case 0:
                        fighters.add(new Common(numCommon));
                        numCommon++;
                    case 1:
                        fighters.add(new Tank(numTanks));
                        numTanks++;
                }
            }
        }

    }

    public void moveKilled(int combatant) {
        deadFighters.add(fighters.remove(combatant));
    }

    // Getters and setters
    public int getAlive() {
        return fighters.size();
    }

    // prints the quantity of each class
    public String getCombatants() {
        if (faction == 0) {
            return "(" + numNewbies + " Newbies, " + numSoldiers + " Soldiers, " + numMercenary + " Mercenaries)";
        } else {
            return "(" + numCommon + " Common, " + numTanks + " Tanks)";
        }
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

    /**
     * Get number of elements in fighters ArrayList.
     * 
     * @return int size of fighters
     */
    public int getNumFighters() {
        return this.fighters.size();
    }
}
