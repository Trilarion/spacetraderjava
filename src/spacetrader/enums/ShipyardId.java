package spacetrader.enums;


public enum ShipyardId implements SpaceTraderEnum {
  NA, // = -1,
  Corellian, // = 0,
  Incom, // = 1,
  Kuat, // = 2,
  Sienar, // = 3,
  Sorosuub;// = 4

  @Override
  public int CastToInt() {
    return ordinal() - 1;
  }

  public static ShipyardId FromInt(int i) {
    return values()[i + 1];
  }
}
