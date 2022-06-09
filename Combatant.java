package ZombieWar;

abstract class Combatant {
    private boolean alive;
    private int health;
    private int attack;

    public Combatant(boolean alive, int health, int attack) {
        this.alive = alive;
        this.health = health;
        this.attack = attack;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDead(boolean death) {
        this.alive = death;
    }

    public void attacks(Combatant combatant) {
        combatant.setHealth(combatant.getHealth() - this.attack);
        if (combatant.getHealth() == 0) {
            combatant.setDead(true);
        }
    }

    public boolean isDead() {
        return alive;
    }
}

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
