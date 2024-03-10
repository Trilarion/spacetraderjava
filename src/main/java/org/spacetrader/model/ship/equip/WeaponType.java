package org.spacetrader.model.ship.equip;

import org.spacetrader.controller.enums.SpaceTraderEnum;
import org.spacetrader.controller.enums.TechLevel;


public enum WeaponType implements SpaceTraderEnum, EquipmentSubType {
    PulseLaser(TechLevel.t5, false, 50, 15, 2000, "PL", "Pulse Laser"),
    BeamLaser(TechLevel.t6, false, 35, 25, 12500, "BL", "Beam Laser"),
    MilitaryLaser(TechLevel.t7, false, 15, 35, 35000, "ML", "Military Laser"),
    MorgansLaser(TechLevel.t8, false, 0, 85, 50000, "ML", "Morgan's Laser"),
    PhotonDisruptor(TechLevel.t6, true, 0, 20, 15000, "PD", "Photon Disruptor"),
    QuantumDistruptor(TechLevel.t8, true, 0, 60, 50000, "QD", "Quantum Disruptor");
    public final String abbr;
    public final String name;
    public final TechLevel tl;
    public final boolean disabler;
    public final int chance;
    public final int cost;
    public final int id;
    public final int power;

    WeaponType(TechLevel t, boolean b, int i, int j, int k, String s, String u) {
        tl = t;
        disabler = b;
        chance = i;
        power = j;
        cost = k;
        abbr = s;
        name = u;
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
