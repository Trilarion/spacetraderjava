package org.spacetrader.main.gui;

import java.util.Hashtable;


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
    static Hashtable<String, SomeStringsForSwitch> specialStrings = new Hashtable<>();

    static {
        specialStrings.put("Monster.com", MonsterCom);
        specialStrings.put("L'Engle", L_Engle);
    }

    static public SomeStringsForSwitch find(String string) {
        SomeStringsForSwitch spacialvalue = specialStrings.get(string);
        if (spacialvalue != null) {
            return spacialvalue;
        }
        try {
            return valueOf(string);
        } catch (IllegalArgumentException e) {
            return __void__;
        }
    }
}
