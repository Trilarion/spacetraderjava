package org.spacetrader.model.ship.equipment;

import org.spacetrader.controller.enums.SpaceTraderEnum;
import org.spacetrader.model.TechLevel;


public enum WeaponType implements SpaceTraderEnum, EquipmentSubType {

    PulseLaser(TechLevel.t5, false, 50, 15, 2000, "PL", "Pulse Laser"),
    BeamLaser(TechLevel.t6, false, 35, 25, 12500, "BL", "Beam Laser"),
    MilitaryLaser(TechLevel.t7, false, 15, 35, 35000, "ML", "Military Laser"),
    MorgansLaser(TechLevel.t8, false, 0, 85, 50000, "ML", "Morgan's Laser"),
    PhotonDisruptor(TechLevel.t6, true, 0, 20, 15000, "PD", "Photon Disruptor"),
    QuantumDisruptor(TechLevel.t8, true, 0, 60, 50000, "QD", "Quantum Disruptor");

    public final String abbreviation;
    public final String name;
    public final TechLevel techLevel;
    public final boolean disabler;
    public final int chance;
    public final int cost;
    public final int id;
    public final int power;

    WeaponType(TechLevel techLevel, boolean b, int change, int power, int cost, String abbreviation, String name) {
        this.techLevel = techLevel;
        disabler = b;
        chance = change;
        this.power = power;
        this.cost = cost;
        this.abbreviation = abbreviation;
        this.name = name;
        id = ordinal();
    }

    public static WeaponType fromId(int i) {
        return values()[i];
    }

    @Override
    public int CastToInt() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int asInteger() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
