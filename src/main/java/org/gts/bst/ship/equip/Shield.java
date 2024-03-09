package org.gts.bst.ship.equip;
import spacetrader.Strings;
import spacetrader.enums.TechLevel;
import spacetrader.util.Hashtable;
import spacetrader.util.Log;


public class Shield extends Equipment {
  private ShieldType _type;
  private int _charge;
  private int _power;
  private int Charge;

  public Shield(Hashtable hash) {
    super(hash);
    _type = ShieldType.fromId(GetValueFromHash(hash, "_type", Integer.class));
    _power = GetValueFromHash(hash, "_power", Integer.class);
    _charge = GetValueFromHash(hash, "_charge", Integer.class);
  }

  public Shield(ShieldType type, int power, int price, TechLevel minTechLevel, int chance) {
    super(org.gts.bst.ship.equip.EquipmentType.Shield, price, minTechLevel, chance);
    _type = type;
    _power = power;
    _charge = _power;
  }

  @Override
  public Equipment Clone() {
    Shield shield = new Shield(_type, _power, _price, _minTech, _chance);
    shield.setCharge(Charge);
    return shield;
  }

  @Override
  public EquipmentSubType SubType() {
    return Type();
  }

  @Override
  public Hashtable Serialize() {
    Hashtable hash = super.Serialize();
    hash.put("_type", _type);
    hash.put("_power", _power);
    hash.put("_charge", _charge);
    return hash;
  }

  @Override
  public String Name() {
    return Strings.ShieldNames[_type.id];
  }

  @Override
  public boolean TypeEquals(Object type) {
    try {
      return (Type() == (ShieldType)type);
    } catch(Exception e) {
      Log.write("Ignored exception: " + e);
      return false;
    }
  }

  public ShieldType Type() {
    return _type;
  }

  public int getCharge() {
    return Charge;
  }

  public int Power() {
    return _power;
  }

  public void setCharge(int charge) {
    Charge = charge;
  }
}
