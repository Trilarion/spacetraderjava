package org.spacetrader.model.enums;


import org.spacetrader.util.IdentifiableEnum;

public enum ReputationType implements IdentifiableEnum {
    Harmless, // = 0,
    MostlyHarmless, // = 1,
    Poor, // = 2,
    Average, // = 3,
    AboveAverage, // = 4,
    Competent, // = 5,
    Dangerous, // = 6,
    Deadly, // = 7,
    Elite;// = 8

    @Override
    public int getId() {
        return ordinal();
    }
}
