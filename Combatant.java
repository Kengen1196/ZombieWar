package ZombieWar;

abstract class Combatant {
    private boolean alive;
    private int health;
    private int attack;
    private String type;

    public Combatant(boolean alive, int health, int attack, String type) {
        this.alive = alive;
        this.health = health;
        this.attack = attack;
        this.type = type;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attacks(Combatant combatant) {
        combatant.setHealth(combatant.getHealth() - this.attack);
    }

    public boolean isDead() {
        if (this.health <= 0) {
            alive = false;
        }
        return alive;
    }
}

class Soldier extends Combatant {
    public Soldier() {
        super(true, 50, 5, "Survivor");
    }
}

class Mercenary extends Combatant {
    public Mercenary() {
        super(true, 100, 10, "Survivor");
    }
}

class Newbie extends Combatant {
    public Newbie() {
        super(true, 20, 2, "Survivor");
    }
}

class Common extends Combatant {
    public Common() {
        super(true, 30, 5, "Zombie");
    }
}

class Tank extends Combatant {
    public Tank() {
        super(true, 150, 20, "Zombie");
    }
}
