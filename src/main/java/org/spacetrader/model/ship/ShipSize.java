package org.spacetrader.model.ship;

import org.spacetrader.controller.enums.SpaceTraderEnum;


// TODO best way for autonumbered enums
public enum ShipSize implements SpaceTraderEnum {
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
    public int CastToInt() {
        return ordinal();
    }
}
