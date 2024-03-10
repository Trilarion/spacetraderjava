package org.spacetrader.model.ship.equip;

import org.spacetrader.controller.enums.SpaceTraderEnum;


public enum GadgetType implements EquipmentSubType, SpaceTraderEnum {
    ExtraCargoBays, // = 0,
    AutoRepairSystem, // = 1,
    NavigatingSystem, // = 2,
    TargetingSystem, // = 3,
    CloakingDevice, // = 4,
    FuelCompactor, // = 5,
    HiddenCargoBays;// = 6

    public static GadgetType FromInt(int i) {
        return values()[i];
    }

    @Override
    public int asInteger() {
        return ordinal();
    }

    @Override
    public int CastToInt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
