package ZombieWar;

abstract class Combatant {
    // Combatant variables
    private boolean alive;
    private int health;
    private int attack;

    // Combatant Instance requires the alive status, health, and attack
    public Combatant(boolean alive, int health, int attack) {
        this.alive = alive;
        this.health = health;
        this.attack = attack;
    }

    // getters and setters
    public int getHealth() {
        return this.health;
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

// All subclasses of Combatant ranging from the surivors to the zombies

class Soldier extends Combatant {
    public Soldier() {
        super(true, 50, 5);
    }
}

class Mercenary extends Combatant {
    public Mercenary() {
        super(true, 100, 10);
    }
}

class Newbie extends Combatant {
    public Newbie() {
        super(true, 20, 2);
    }
}

class Common extends Combatant {
    public Common() {
        super(true, 30, 5);
    }
}

class Tank extends Combatant {
    public Tank() {
        super(true, 150, 20);
    }
}
