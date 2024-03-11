package org.spacetrader.model.enums;


public enum GameEndType implements IdentifiableEnum {
    NA, // = -1,
    Killed, // = 0,
    Retired, // = 1,
    BoughtMoon, // = 2,
    BoughtMoonGirl; // = 3

    public static GameEndType FromInt(int i) {
        return values()[i + 1];
    }

    @Override
    public int getId() {
        return ordinal() - 1;
    }
}
