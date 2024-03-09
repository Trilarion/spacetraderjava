package org.spacetrader.ship.equip;

import org.spacetrader.main.enums.SpaceTraderEnum;


public enum EquipmentType implements SpaceTraderEnum {
    Weapon,
    Shield,
    Gadget;

    public static EquipmentType FromInt(int i) {
        return values()[i];
    }

    @Override
    public int CastToInt() {
        return ordinal();
    }
}
