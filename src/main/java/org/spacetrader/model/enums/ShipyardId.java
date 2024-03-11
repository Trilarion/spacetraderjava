package org.spacetrader.model.enums;


public enum ShipyardId implements IdentifiableEnum {
    NA, // = -1,
    Corellian, // = 0,
    Incom, // = 1,
    Kuat, // = 2,
    Sienar, // = 3,
    Sorosuub;// = 4

    public static ShipyardId FromInt(int i) {
        return values()[i + 1];
    }

    @Override
    public int getId() {
        return ordinal() - 1;
    }
}
