package spacetrader.enums;


public enum GameEndType implements SpaceTraderEnum {
  NA, // = -1,
  Killed, // = 0,
  Retired, // = 1,
  BoughtMoon, // = 2,
  BoughtMoonGirl; // = 3

  @Override
  public int CastToInt() {
    return ordinal() - 1;
  }

  public static GameEndType FromInt(int i) {
    return values()[i + 1];
  }
}
