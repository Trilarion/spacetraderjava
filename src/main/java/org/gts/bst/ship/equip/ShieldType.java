package org.gts.bst.ship.equip;
import spacetrader.enums.SpaceTraderEnum;


public enum ShieldType implements SpaceTraderEnum, EquipmentSubType {
  Energy,
  Reflective,
  Lightning;
  public final int id;

  private ShieldType() {
    id = ordinal();
  }

  @Override
  public int asInteger() {
    return id;
  }

  public static ShieldType fromId(int i) {
    return values()[i];
  }

  @Override
  public int CastToInt() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
