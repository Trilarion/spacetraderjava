package org.spacetrader.events;
import org.spacetrader.main.enums.SpaceTraderEnum;


public enum EncounterResult implements SpaceTraderEnum {
  Continue,
  Normal,
  Killed,
  EscapePod,
  Arrested;

  @Override
  public int CastToInt() {
    return ordinal();
  }
}
