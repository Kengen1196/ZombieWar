package ZombieWar;

//Added a weapon class to give to the combatants
abstract class Weapons {
    // Damage is an addition to the combatant's damage, accuracy determines if they
    // are hit, and type is the weapon name
    private int damage;
    private int accuracy;
    private String type;

    // basic super constructor all weapons will use
    public Weapons(int dmg, int acc, String type) {
        this.damage = dmg;
        this.accuracy = acc;
        this.type = type;
    }

    // getters returning damage, name, and accuracy
    public String getType() {
        return this.type;
    }

    public int getDmg() {
        return this.damage;
    }

    public int getAcc() {
        return accuracy;
    }
}

// all weapon classes with their specified stats
class Shotgun extends Weapons {
    public Shotgun() {
        super(6, 60, "Shotgun");
    }
}

class Submachinegun extends Weapons {
    public Submachinegun() {
        super(2, 45, "Submachinegun");
    }
}

class AssaultRifle extends Weapons {
    public AssaultRifle() {
        super(3, 80, "Assault Rifle");
    }
}

class Pistol extends Weapons {
    public Pistol() {
        super(2, 70, "Pistol");
    }
}

class Axe extends Weapons {
    public Axe() {
        super(6, 90, "Axe");
    }
}

class Crowbar extends Weapons {
    public Crowbar() {
        super(4, 80, "Crowbar");
    }
}

class FryingPan extends Weapons {
    public FryingPan() {
        super(2, 80, "Frying Pan");
    }
}

class Mouth extends Weapons {
    public Mouth() {
        super(0, 80, "Mouth");
    }
}
