package org.spacetrader.model.ship.equipment;

import org.spacetrader.model.enums.TechLevel;
import org.spacetrader.util.Log;

import java.util.Hashtable;


public class Weapon extends Equipment {

    private static final String[] ss = {
            "_type", "_power", "_disabling"
    };
    private final WeaponType type;
    private final boolean disabling;
    private final int power;

    public Weapon(Hashtable ht) {
        super(ht);
        type = WeaponType.fromId(GetValueFromHash(ht, ss[0], Integer.class));
        power = GetValueFromHash(ht, ss[1], Integer.class);
        disabling = GetValueFromHash(ht, ss[2], false);
    }

    public Weapon(WeaponType weaponType, int power, boolean disabling, int price, TechLevel techLevel, int chance) {
        super(EquipmentType.Weapon, price, techLevel, chance);
        type = weaponType;
        this.power = power;
        this.disabling = disabling;
    }

    @Override
    public Equipment Clone() {
        return new Weapon(type, power, disabling, price, minTech, chance);
    }

    @Override
    public EquipmentSubType SubType() {
        //TODO: Is this supposed to be irrelevant? GAC
        return type;
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put(ss[0], type.id);
        hash.put(ss[1], power);
        hash.put(ss[2], disabling);
        return hash;
    }

    @Override
    public String Name() {
        return type.name;
    }

    @Override
    public boolean TypeEquals(Object type) {
        boolean equal = false;
        try {
            if (this.type == type) {
                equal = true;
            }
        } catch (Exception e) {
            Log.write("Ignored exception " + e);
        }
        return equal;
    }

    public WeaponType Type() {
        return type;
    }

    public boolean Disabling() {
        return disabling;
    }

    public int Power() {
        return power;
    }
}
