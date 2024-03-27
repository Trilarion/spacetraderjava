package org.spacetrader.model.enums;


import org.spacetrader.util.IdentifiableEnum;

public enum GameEndType implements IdentifiableEnum {
    NA, // = -1,
    Killed, // = 0,
    Retired, // = 1,
    BoughtMoon, // = 2,
    BoughtMoonGirl; // = 3

    public static GameEndType FromInt(final int i) {
        return GameEndType.values()[i + 1];
    }

    @Override
    public int getId() {
        return ordinal() - 1;
    }
}
