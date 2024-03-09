package spacetrader.enums;


public enum ReputationType implements SpaceTraderEnum {
  Harmless, // = 0,
  MostlyHarmless, // = 1,
  Poor, // = 2,
  Average, // = 3,
  AboveAverage, // = 4,
  Competent, // = 5,
  Dangerous, // = 6,
  Deadly, // = 7,
  Elite;// = 8

  @Override
  public int CastToInt() {
    return ordinal();
  }
}
