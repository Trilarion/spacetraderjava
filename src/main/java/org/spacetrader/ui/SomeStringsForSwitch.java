package org.spacetrader.ui;

import java.util.Hashtable;

// TODO how is this used, document and maybe refactor
public enum SomeStringsForSwitch {
    Bazaar,
    Cover,
    DeLorean,
    Diamond,
    Energize,
    Events,
    Fame,
    Go,
    Ice,
    Pirate,
    Police,
    Trader,
    Indemnity,
    IOU,
    Iron,
    Juice,
    Knack,
    LifeBoat,
    L_Engle,
    MonsterCom,
    PlanB,
    Posse,
    RapSheet,
    Rarity,
    Scratch,
    Skin,
    Status,
    Artifact,
    Dragonfly,
    Experiment,
    Gemulon,
    Japori,
    Jarek,
    Moon,
    Reactor,
    Princess,
    Scarab,
    Sculpture,
    SpaceMonster,
    Wild,
    Swag,
    Test,
    Tool,
    Varmints,
    Yellow,
    Cheetah,
    I,
    N,
    P,
    F,
    T,
    E,
    S,
    Q,
    M,
    __void__;
    static final Hashtable<String, SomeStringsForSwitch> specialStrings = new Hashtable<>();

    static {
        SomeStringsForSwitch.specialStrings.put("Monster.com", SomeStringsForSwitch.MonsterCom);
        SomeStringsForSwitch.specialStrings.put("L'Engle", SomeStringsForSwitch.L_Engle);
    }

    static public SomeStringsForSwitch find(final String string) {
        final SomeStringsForSwitch spacialvalue = SomeStringsForSwitch.specialStrings.get(string);
        if (spacialvalue != null) {
            return spacialvalue;
        }
        try {
            return SomeStringsForSwitch.valueOf(string);
        } catch (final IllegalArgumentException e) {
            return SomeStringsForSwitch.__void__;
        }
    }
}
