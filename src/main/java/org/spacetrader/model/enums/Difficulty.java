package org.spacetrader.model.enums;


import org.spacetrader.util.IdentifiableEnum;

public enum Difficulty implements IdentifiableEnum {
    Beginner(2),
    Easy(1),
    Normal(0),
    Hard(-1),
    Impossible(-2);
    private final int skillAdjust;

    Difficulty(int skillAdjust) {
        this.skillAdjust = skillAdjust;
    }

    public static Difficulty FromInt(int i) {
        return Difficulty.values()[i];
    }

    @Override
    public int getId() {
        return ordinal();
    }

    // TODO since this is a simple addition, it might be somewhere else
    public int adjustSkill(int skill) {
        return skill + skillAdjust;
    }
}
