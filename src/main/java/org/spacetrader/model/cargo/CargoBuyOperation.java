package org.spacetrader.model.cargo;


public enum CargoBuyOperation {
    BuySystem(0, "Buy from system"),
    BuyTrader(1, "Buy from trader"),
    InPlunder(2, "Get via plunder");

    public final String name;
    public final int id;

    CargoBuyOperation(final int id, final String name) {
        this.name = name;
        this.id = id;
    }

    public static CargoBuyOperation fromId(final int i) {
        return CargoBuyOperation.values()[i];
    }
}
