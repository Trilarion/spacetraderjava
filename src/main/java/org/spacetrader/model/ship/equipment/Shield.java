package org.spacetrader.model.ship.equipment;

import org.spacetrader.model.SerializableObject;
import org.spacetrader.model.enums.TechLevel;
import org.spacetrader.ui.Strings;
import org.spacetrader.util.Log;

import java.util.Hashtable;


public class Shield extends Equipment {
    private final ShieldType type;
    private final int charge;
    private final int power;
    private int Charge;

    public Shield(final Hashtable hash) {
        super(hash);
        type = ShieldType.fromId(SerializableObject.GetValueFromHash(hash, "_type", Integer.class));
        power = SerializableObject.GetValueFromHash(hash, "_power", Integer.class);
        charge = SerializableObject.GetValueFromHash(hash, "_charge", Integer.class);
    }

    public Shield(final ShieldType type, final int power, final int price, final TechLevel minTechLevel, final int chance) {
        super(EquipmentType.Shield, price, minTechLevel, chance);
        this.type = type;
        this.power = power;
        charge = this.power;
    }

    @Override
    public Equipment Clone() {
        final Shield shield = new Shield(type, power, price, minTech, chance);
        shield.Charge = Charge;
        return shield;
    }

    @Override
    public EquipmentSubType SubType() {
        return Type();
    }

    @Override
    public Hashtable Serialize() {
        final Hashtable hash = super.Serialize();
        hash.put("_type", type);
        hash.put("_power", power);
        hash.put("_charge", charge);
        return hash;
    }

    @Override
    public String Name() {
        return Strings.ShieldNames[type.id];
    }

    @Override
    public boolean TypeEquals(final Object type) {
        try {
            return (Type() == type);
        } catch (final Exception e) {
            Log.write("Ignored exception: " + e);
            return false;
        }
    }

    public ShieldType Type() {
        return type;
    }

    public int getCharge() {
        return Charge;
    }

    public void setCharge(final int charge) {
        Charge = charge;
    }

    public int Power() {
        return power;
    }
}
