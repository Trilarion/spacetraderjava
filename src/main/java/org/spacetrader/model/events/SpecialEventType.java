package org.spacetrader.model.events;

import org.spacetrader.util.IdentifiableEnum;


public enum SpecialEventType implements IdentifiableEnum {

    //public static final String[] SpecialEventTitles = new String[]{
//  "Alien Artifact", "Artifact Delivery", "Cargo For Sale", "Dragonfly", "Dragonfly Destroyed", "Weird Ship", "Lightning Ship",
//  "Lightning Shield", "Strange Ship", "Erase Record", "Dangerous Experiment", "Experiment Failed", "Disaster Averted",
//  "Alien Invasion", "Fuel Compactor", "Gemulon Invaded", "Gemulon Rescued", "Japori Disease", "Medicine Delivery",
//  "Ambassador Jarek", "Jarek Gets Out", "Lottery Winner", "Moon For Sale", "Retirement", "Morgan's Reactor",
//  "Reactor Delivered", "Install Morgan's Laser", "Scarab Stolen", "Scarab Destroyed", "Upgrade Hull", "Skill Increase",
//  "Space Monster", "Monster Killed", "Merchant Prince", "Tribble Buyer", "Jonathan Wild", "Wild Gets Out",
//  "Stolen Sculpture", "Sculpture Delivered", "Install Hidden Compartments", "Kidnapped", "Aggressive Ship",
//};
    NA(""), // = -1,
    Artifact(""), // = 0,
    ArtifactDelivery(""), // = 1,
    CargoForSale(""), // = 2,
    Dragonfly(""), // = 3,
    DragonflyBaratas(""), // = 4,
    DragonflyDestroyed(""), // = 5,
    DragonflyMelina(""), // = 6,
    DragonflyRegulas(""), // = 7,
    DragonflyShield(""), // = 8,
    EraseRecord(""), // = 9,
    Experiment(""), // = 10,
    ExperimentFailed(""), // = 11,
    ExperimentStopped(""), // = 12,
    Gemulon(""), // = 13,
    GemulonFuel(""), // = 14,
    GemulonInvaded(""), // = 15,
    GemulonRescued(""), // = 16,
    Japori(""), // = 17,
    JaporiDelivery(""), // = 18,
    Jarek(""), // = 19,
    JarekGetsOut(""), // = 20,
    Lottery(""), // = 21,
    Moon(""), // = 22,
    MoonRetirement(""), // = 23,
    Reactor(""), // = 24,
    ReactorDelivered(""), // = 25,
    ReactorLaser(""), // = 26,
    Scarab(""), // = 27,
    ScarabDestroyed(""), // = 28,
    ScarabUpgradeHull(""), // = 29,
    Skill(""), // = 30,
    SpaceMonster(""), // = 31,
    SpaceMonsterKilled(""), // = 32,
    Tribble(""), // = 33,
    TribbleBuyer(""), // = 34,
    Wild(""), // = 35,
    WildGetsOut(""), // = 36,
    Sculpture(""), // = 37,
    SculptureDelivered(""), // = 38,
    SculptureHiddenBays(""), // = 39,
    //  "Dangerous Scorpion", "Royal Rescue", "Quantum Disruptor", "Royal Return"
    Princess(""), // = 40,
    PrincessCentauri(""), // = 41,
    PrincessInthara(""), // = 42,
    PrincessQonos(""), // = 43,
    PrincessQuantum(""), // = 44,
    PrincessReturned(""); // = 45
    public final String name;

    SpecialEventType(String s) {
        name = s;
    }

    public static SpecialEventType FromInt(int i) {
        return values()[i + 1];
    }

    @Override
    public int getId() {
        return ordinal() - 1;
    }
}
