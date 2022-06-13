package ZombieWar;

abstract class Combatant {
    // Combatant variables
    private boolean alive;
    private int health;
    private final int attack;
    private final String type;
    private int id;
    
    // Added nickname variable
    private String nickname;

    // Combatant Instance requires the alive status, health, and attack
    public Combatant(boolean alive, int health, int attack, String type) {
        this.alive = alive;
        this.health = health;
        this.attack = attack;
        this.type = type;
    }

    // getters and setters
    public int getHealth() {
        return this.health;
    }

    // Each entity has a name which is a combination of its name and id
    public String getName() {
        return this.type + " " + this.id;
    }
    
    /**
     * Return the value of nickname for this Combatant.
     * @return 
     */
    public String getNickname() {
        return this.nickname;
    }
    
    /**
     * Return the value of type for this Combatant.
     * @return 
     */
    public String getType() {
        return this.type;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDead(boolean death) {
        this.alive = death;
    }
    
    /**
     * Set nickname to specified value.
     * @param nickname 
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    // attack method which decreases other combatant's health
    public void attacks(Combatant combatant) {
        // Add dialogue
        System.out.println("\n" + this.getNickname() + ": \"" + this.speak() + "\"");
        System.out.println(combatant.getNickname() + ": \"" + combatant.speak() + "\"" + "\n");
        
        combatant.setHealth(combatant.getHealth() - this.attack);
        // sets the defending combatant status to dead if helath is less than 0
        if (combatant.getHealth() <= 0) {
            combatant.setDead(true);
        }
    }

    // Checks if Combatant is dead
    public boolean isDead() {
        return alive;
    }
    
    /**
     * Return attack quote of appropriate type for the calling Combatant.
     * @return 
     */
    protected String speak() {
        // Check for combatant type, then generate appropriate quote
        if (this.getType().equals("Tank") || 
                this.getType().equals("Common")) {
            // Zombie combatant
            return zombieQuote();
        } else {
            // Human combatant
            return humanQuote();
        }
    }
    
    /**
     * Generate attack quote for zombie type Combatant.
     * @return 
     */
    protected static String zombieQuote() {
        String[] zombieQuotes = {
            "Mrh?", 
            "Graaaaagh.", 
            "Graaagh!", 
            "Braaaaaaaains...", 
            "Mraaa...", 
            "Brrrrnhr.", 
            "Gar grngh.",
            "...", 
            "Ahhhhhrngh!", 
            "Brrannngh?", 
            "Mrh! Mrh!", 
            "...zzzzz..."
        };
        
        int index = (int) (Math.random() * zombieQuotes.length);
  

        return zombieQuotes[index];
        
    }
    
    /**
     * Generate attack quote for human type Combatant
     * @return 
     */
    protected static String humanQuote() {
        String[] humanQuotes = {
            "We're not afraid!",
            "Cower before us!",
            "Our time has come!",
            "Today is a good day to die!",
            "We never tire!",
            "Here we come!",
            "We will never stop!",
            "We shall be remembered!",
            "For our people!",
            "We stand together!",
            "For Frodo.",
            "Leave nothing standing!",
            "Freedom!",
            "We have arrived!",
            "Let's go!"
            
        };
        
        int index = (int) (Math.random() * humanQuotes.length);
  

        return humanQuotes[index];
    }
    
    /**
     * Generate random nickname for human type Combatant
     * @return 
     */
    protected static String randomHumanName() {
        String[] names = {
            "Mary",
            "Evelyn",
            "Cora",
            "Norma",
            "Felicia",
            "Shannon",
            "Allison",
            "Sharon",
            "Alexandria",
            "Monique",
            "Vincent",
            "Victor",
            "Delbert",
            "Archie",
            "Melvin",
            "Warren",
            "Manuel",
            "Jeremiah",
            "Brandon",
            "Aidan"
        };
        
        int index = (int) (Math.random() * names.length);
  

        return names[index];
    }
    
    /**
     * Generate random nickname for Zombie type Combatant
     * @return 
     */
    protected static String randomZombieName() {
        String[] names = {
            "Popsicle",
            "Yelper",
            "Bloater",
            "Scratcher", 
            "Nibbler",
            "Spurter",
            "Brooder",
            "Spitter",
            "Shrieker",
            "Smarty Pants",
            "Biter",
            "Reeker",
            "Squealer",
            "Lurker"
        };
        
        int index = (int) (Math.random() * names.length);
  

        return names[index];
    }
}

// All subclasses of Combatant ranging from the surivors to the zombies each
// requires and id
// Modified to add a randomly generated nickname for each type of combatant.


class Soldier extends Combatant {
    public Soldier(int id) {
        super(true, 50, 5, "Soldier");
        super.setID(id);
        super.setNickname(randomHumanName());
    }
}

class Mercenary extends Combatant {
    public Mercenary(int id) {
        super(true, 100, 10, "Mercenary");
        super.setID(id);
        super.setNickname(randomHumanName());
    }
}

class Newbie extends Combatant {
    public Newbie(int id) {
        super(true, 20, 2, "Newbie");
        super.setID(id);
        super.setNickname(randomHumanName());
    }
}

class Common extends Combatant {
    public Common(int id) {
        super(true, 30, 5, "Common");
        super.setID(id);
        super.setNickname(randomZombieName());
    }
}

class Tank extends Combatant {
    public Tank(int id) {
        super(true, 150, 20, "Tank");
        super.setID(id);
        super.setNickname(randomZombieName());
    }
}

