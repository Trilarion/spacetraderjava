package org.spacetrader.model;

import org.spacetrader.controller.enums.SpaceTraderEnum;


public enum Difficulty implements SpaceTraderEnum {
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
        return values()[i];
    }

    @Override
    public int CastToInt() {
        return ordinal();
    }

    // TODO since this is a simple addition, it might be somewhere else
    public int adjustSkill(int skill) {
        return skill + skillAdjust;
    }
}
