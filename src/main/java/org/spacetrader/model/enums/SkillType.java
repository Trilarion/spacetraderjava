package org.spacetrader.model.enums;


public enum SkillType implements IdentifiableEnum {
    NA, // = -1,
    Pilot, // = 0,
    Fighter, // = 1,
    Trader, // = 2,
    Engineer;// = 3

    public static SkillType FromInt(int i) {
        return values()[i + 1];
    }

    @Override
    public int getId() {
        return ordinal() - 1;
    }
}
