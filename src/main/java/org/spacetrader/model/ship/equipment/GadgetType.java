package org.spacetrader.model.ship.equipment;

import org.spacetrader.util.IdentifiableEnum;


public enum GadgetType implements EquipmentSubType, IdentifiableEnum {
    ExtraCargoBays, // = 0,
    AutoRepairSystem, // = 1,
    NavigatingSystem, // = 2,
    TargetingSystem, // = 3,
    CloakingDevice, // = 4,
    FuelCompactor, // = 5,
    HiddenCargoBays;// = 6

    public static GadgetType FromInt(final int i) {
        return GadgetType.values()[i];
    }

    @Override
    public int asInteger() {
        return ordinal();
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
