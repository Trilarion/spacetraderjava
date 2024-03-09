package org.spacetrader.ship.equip;

import org.spacetrader.main.enums.SpaceTraderEnum;


public enum ShieldType implements SpaceTraderEnum, EquipmentSubType {
    Energy,
    Reflective,
    Lightning;
    public final int id;

    private ShieldType() {
        id = ordinal();
    }

    public static ShieldType fromId(int i) {
        return values()[i];
    }

    @Override
    public int asInteger() {
        return id;
    }

    @Override
    public int CastToInt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
