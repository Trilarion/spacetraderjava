package org.gts.bst.events;
import spacetrader.enums.SpaceTraderEnum;


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
