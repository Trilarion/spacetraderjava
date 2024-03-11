package org.spacetrader.model.events;

import org.spacetrader.model.enums.IdentifiableEnum;


public enum VeryRareEncounter implements IdentifiableEnum {

    MarieCeleste("Marie Celeste"), // = 0,
    CaptainAhab("Captain Ahab"), // = 1,
    CaptainConrad("Captain Conrad"), // = 2,
    CaptainHuie("Captain Huie"), // = 3,
    BottleOld("Dated Tonic"), // = 4,
    BottleGood("Good Tonic"); // = 5
    public final String name;
    public final int id;

    VeryRareEncounter(String name) {
        this.name = name;
        id = ordinal();
    }

    @Override
    public int getId() {
        return ordinal();
    }
}
