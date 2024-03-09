package org.spacetrader.cargo;

import org.spacetrader.main.enums.SpaceTraderEnum;


public enum CargoSellOp implements SpaceTraderEnum {
    SellSystem,
    SellTrader,
    Dump,
    Jettison;

    @Override
    public int CastToInt() {
        return ordinal();
    }
}
