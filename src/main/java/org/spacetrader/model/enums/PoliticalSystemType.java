package org.spacetrader.model.enums;


import org.spacetrader.util.IdentifiableEnum;

public enum PoliticalSystemType implements IdentifiableEnum {
    Anarchy,//= 0,
    Capitalist,//= 1,
    Communist,//= 2,
    Confederacy,//= 3,
    Corporate,//= 4,
    Cybernetic,//= 5,
    Democracy,//= 6,
    Dictatorship,//= 7,
    Fascist,//= 8,
    Feudal,//= 9,
    Military,//= 10,
    Monarchy,//= 11,
    Pacifist,//= 12,
    Socialist,//= 13,
    Satori,//= 14,
    Technocracy,//= 15,
    Theocracy;//= 16

    public static PoliticalSystemType FromInt(int i) {
        return values()[i];
    }

    @Override
    public int getId() {
        return ordinal();
    }
}
