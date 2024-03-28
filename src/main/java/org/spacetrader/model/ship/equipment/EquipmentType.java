package org.spacetrader.model.ship.equipment;

import org.spacetrader.util.IdentifiableEnum;


public enum EquipmentType implements IdentifiableEnum {
    Weapon,
    Shield,
    Gadget;

    public static EquipmentType FromInt(int i) {
        return EquipmentType.values()[i];
    }

    @Override
    public int getId() {
        return ordinal();
    }
}
