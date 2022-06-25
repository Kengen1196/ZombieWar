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
    private int choice;
    private int wc;

    // Group initiates based on what the inputted faction 0 for survivors while any
    // other for zombies
    public Group(int faction) {
        this.faction = faction;
        // generates a random amount of combatants. Size is arbritrary to decided by me.
        numCombatants = rand.nextInt(20);
        Weapons weapon = null;

        // Function for generating survivors
        if (faction == 0) {

            // Loops adding a random survivor entity based on random number generated and
            // assigns an id
            for (int x = 0; x < numCombatants; x++) {
                wc = rand.nextInt(7);
                // weapons are chosen at random and assigned during creation
                switch (wc) {
                    case 0:
                        weapon = new Shotgun();
                        break;
                    case 1:
                        weapon = new Submachinegun();
                        break;
                    case 2:
                        weapon = new AssaultRifle();
                        break;
                    case 3:
                        weapon = new Pistol();
                        break;
                    case 4:
                        weapon = new Axe();
                        break;
                    case 5:
                        weapon = new Crowbar();
                        break;
                    case 6:
                        weapon = new FryingPan();
                        break;
                }

                choice = rand.nextInt(3);
                switch (choice) {
                    case 0:
                        fighters.add(new Newbie(numNewbies, weapon));
                        numNewbies++;

                    case 1:
                        fighters.add(new Mercenary(numMercenary, weapon));
                        numMercenary++;

                    case 2:
                        fighters.add(new Soldier(numSoldiers, weapon));
                        numSoldiers++;
                }
            }
            // Zombie generation function
        } else {
            // Loops for zombie entities based on random number generated
            for (int x = 0; x < numCombatants; x++) {
                choice = rand.nextInt(2);
                weapon = new Mouth();
                switch (choice) {
                    case 0:
                        fighters.add(new Common(numCommon, weapon));
                        numCommon++;
                    case 1:
                        fighters.add(new Tank(numTanks, weapon));
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
