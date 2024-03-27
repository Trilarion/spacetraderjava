package org.spacetrader.model.enums;


import org.spacetrader.util.IdentifiableEnum;

public enum OpponentType implements IdentifiableEnum {
    Bottle,
    FamousCaptain,
    Mantis,
    Pirate,
    Police,
    Trader;

    @Override
    public int getId() {
        return ordinal();
    }
}
