package org.spacetrader.model.enums;


import org.spacetrader.util.IdentifiableEnum;

public enum SystemPressure implements IdentifiableEnum {
    None("under no particular pressure"),//= 0,
    War("at war"),//= 1,
    Plague("ravaged by plague"),//= 2,
    Drought("suffering from a drought"),//= 3,
    Boredom("suffering from extreme boredom"),//= 4,
    Cold("suffering from a cold spell"),//= 5,
    CropFailure("suffering from a crop failure"),//= 6,
    Employment("lacking enough workers");//= 7
    public final String name;

    SystemPressure(String name) {
        this.name = name;
    }

    public static SystemPressure FromInt(int i) {
        return SystemPressure.values()[i];
    }

    @Override
    public int getId() {
        return ordinal();
    }
}
