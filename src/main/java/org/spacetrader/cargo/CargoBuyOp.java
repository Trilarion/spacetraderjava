package org.spacetrader.cargo;


public enum CargoBuyOp {
    BuySystem(0, "Buy from system"),
    BuyTrader(1, "Buy from trader"),
    InPlunder(2, "Get via plunder");
    public final String name;
    public final int id;

    CargoBuyOp(int i, String s) {
        name = s;
        id = i;
    }

    public static CargoBuyOp fromId(int i) {
        return values()[i];
    }
}
