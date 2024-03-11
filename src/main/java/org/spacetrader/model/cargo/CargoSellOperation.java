package org.spacetrader.model.cargo;

import org.spacetrader.model.enums.IdentifiableEnum;


public enum CargoSellOperation implements IdentifiableEnum {
    SellSystem,
    SellTrader,
    Dump,
    Jettison;

    @Override
    public int getId() {
        return ordinal();
    }
}
