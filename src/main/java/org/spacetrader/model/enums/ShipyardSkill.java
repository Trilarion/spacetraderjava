package org.spacetrader.model.enums;


import org.spacetrader.util.IdentifiableEnum;

public enum ShipyardSkill implements IdentifiableEnum {
    CrewQuarters,    // = 0, // Crew Quarters take up 2 fewer units
    FuelBase,        // = 1, // Fuel Base is 2 greater
    HullPerUnit,     // = 2, // Number of Hull Points per unit is 5 greater
    ShieldSlotUnits, // = 3, // Shield Slots take up 2 fewer units
    WeaponSlotUnits; // = 4  // Weapon Slots take up 2 fewer units

    @Override
    public int getId() {
        return ordinal();
    }
}
