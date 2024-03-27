package org.spacetrader.model.enums;


import org.spacetrader.util.IdentifiableEnum;

public enum Difficulty implements IdentifiableEnum {
    Beginner(2),
    Easy(1),
    Normal(0),
    Hard(-1),
    Impossible(-2);
    private final int skillAdjust;

    Difficulty(final int skillAdjust) {
        this.skillAdjust = skillAdjust;
    }

    public static Difficulty FromInt(final int i) {
        return Difficulty.values()[i];
    }

    @Override
    public int getId() {
        return ordinal();
    }

    // TODO since this is a simple addition, it might be somewhere else
    public int adjustSkill(final int skill) {
        return skill + skillAdjust;
    }
}
