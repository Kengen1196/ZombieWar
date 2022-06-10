package ZombieWar;

abstract class Combatant {
    // Combatant variables
    private boolean alive;
    private int health;
    private int attack;
    private String type;
    private int id;

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

    public void setID(int id) {
        this.id = id;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDead(boolean death) {
        this.alive = death;
    }

    // attack method which decreases other combatant's health
    public void attacks(Combatant combatant) {
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
}

// All subclasses of Combatant ranging from the surivors to the zombies each
// requires and id

class Soldier extends Combatant {
    public Soldier(int id) {
        super(true, 50, 5, "Soldier");
        super.setID(id);
    }
}

class Mercenary extends Combatant {
    public Mercenary(int id) {
        super(true, 100, 10, "Mercenary");
        super.setID(id);
    }
}

class Newbie extends Combatant {
    public Newbie(int id) {
        super(true, 20, 2, "Newbie");
        super.setID(id);
    }
}

class Common extends Combatant {
    public Common(int id) {
        super(true, 30, 5, "Common");
        super.setID(id);
    }
}

class Tank extends Combatant {
    public Tank(int id) {
        super(true, 150, 20, "Tank");
        super.setID(id);
    }
}
