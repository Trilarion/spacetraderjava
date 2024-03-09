package org.gts.bst.ship.equip;
import spacetrader.enums.SpaceTraderEnum;


public enum EquipmentType implements SpaceTraderEnum {
  Weapon,
  Shield,
  Gadget;

  @Override
  public int CastToInt() {
    return ordinal();
  }

  public static EquipmentType FromInt(int i) {
    return values()[i];
  }
}
