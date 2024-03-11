package org.spacetrader.model.events;

import org.spacetrader.model.enums.IdentifiableEnum;


public enum EncounterResult implements IdentifiableEnum {

    Continue,
    Normal,
    Killed,
    EscapePod,
    Arrested;

    @Override
    public int getId() {
        return ordinal();
    }
}
