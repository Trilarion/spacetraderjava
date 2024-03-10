package org.spacetrader.model.cargo;

import org.spacetrader.controller.enums.SpaceTraderEnum;


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
