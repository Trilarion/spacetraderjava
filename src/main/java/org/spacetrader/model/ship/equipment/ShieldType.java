package org.spacetrader.model.ship.equipment;

import org.spacetrader.util.IdentifiableEnum;


public enum ShieldType implements IdentifiableEnum, EquipmentSubType {
    Energy,
    Reflective,
    Lightning;
    public final int id;

    ShieldType() {
        id = ordinal();
    }

    public static ShieldType fromId(int i) {
        return ShieldType.values()[i];
    }

    @Override
    public int asInteger() {
        return id;
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
