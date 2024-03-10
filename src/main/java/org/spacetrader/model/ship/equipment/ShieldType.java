package org.spacetrader.model.ship.equipment;

import org.spacetrader.controller.enums.SpaceTraderEnum;


public enum ShieldType implements SpaceTraderEnum, EquipmentSubType {
    Energy,
    Reflective,
    Lightning;
    public final int id;

    ShieldType() {
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
