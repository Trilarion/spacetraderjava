package org.spacetrader.model.cargo;

import org.spacetrader.util.IdentifiableEnum;


public enum TradeItemType implements IdentifiableEnum {
    NA(""),//					= -1,
    Water("Water"),//			= 0,
    Furs("Furs"),//				= 1,
    Food("Food"),//				= 2,
    Ore("Ore"),//				= 3,
    Games("Games"),//			= 4,
    Firearms("Firearms"),//		= 5,
    Medicine("Medicine"),//		= 6,
    Machines("Machines"),//		= 7,
    Narcotics("Narcotics"),//	= 8,
    Robots("Robots");//			= 9
    public final String name;

    TradeItemType(String s) {
        name = s;
    }

    @Override
    public int getId() {
        return ordinal() - 1;
    }
}
