package org.spacetrader.ship;
import org.spacetrader.main.enums.SpaceTraderEnum;


public enum ShipSize implements SpaceTraderEnum {
  Tiny, // = 0,
  Small, // = 1,
  Medium, // = 2,
  Large, // = 3,
  Huge, // = 4,
  Gargantuan; // = 5

  @Override
  public int CastToInt() {
    return ordinal();
  }

  public static ShipSize FromInt(int i) {
    return values()[i];
  }
}
