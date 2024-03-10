package org.spacetrader.controller.enums;


public enum SystemPressure implements SpaceTraderEnum {
    None("under no particular pressure"),//= 0,
    War("at war"),//= 1,
    Plague("ravaged by plague"),//= 2,
    Drought("suffering from a drought"),//= 3,
    Boredom("suffering from extreme boredom"),//= 4,
    Cold("suffering from a cold spell"),//= 5,
    CropFailure("suffering from a crop failure"),//= 6,
    Employment("lacking enough workers");//= 7
    public final String name;

    SystemPressure(String s) {
        name = s;
    }

    public static SystemPressure FromInt(int i) {
        return values()[i];
    }

    @Override
    public int CastToInt() {
        return ordinal();
    }
}
