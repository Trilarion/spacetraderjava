package org.gts.bst.ship.equip;
import spacetrader.enums.SpaceTraderEnum;


public enum GadgetType implements EquipmentSubType, SpaceTraderEnum {
  ExtraCargoBays, // = 0,
  AutoRepairSystem, // = 1,
  NavigatingSystem, // = 2,
  TargetingSystem, // = 3,
  CloakingDevice, // = 4,
  FuelCompactor, // = 5,
  HiddenCargoBays;// = 6

  @Override
  public int asInteger() {
    return ordinal();
  }

  public static GadgetType FromInt(int i) {
    return values()[i];
  }

  @Override
  public int CastToInt() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
