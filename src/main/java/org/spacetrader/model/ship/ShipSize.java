package org.spacetrader.model.ship;

import org.spacetrader.model.enums.IdentifiableEnum;

public enum ShipSize implements IdentifiableEnum {

    Tiny, // = 0,
    Small, // = 1,
    Medium, // = 2,
    Large, // = 3,
    Huge, // = 4,
    Gargantuan; // = 5

    public static ShipSize FromInt(int i) {
        return values()[i];
    }

    @Override
    public int getId() {
        return ordinal();
    }
}
