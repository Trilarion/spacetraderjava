package org.spacetrader.model.events;

import org.spacetrader.controller.enums.SpaceTraderEnum;


public enum EncounterResult implements SpaceTraderEnum {
    Continue,
    Normal,
    Killed,
    EscapePod,
    Arrested;

    @Override
    public int CastToInt() {
        return ordinal();
    }
}
