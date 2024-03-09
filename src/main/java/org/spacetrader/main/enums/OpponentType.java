package org.spacetrader.main.enums;


public enum OpponentType implements SpaceTraderEnum {
  Bottle,
  FamousCaptain,
  Mantis,
  Pirate,
  Police,
  Trader;

  @Override
  public int CastToInt() {
    return ordinal();
  }
}
