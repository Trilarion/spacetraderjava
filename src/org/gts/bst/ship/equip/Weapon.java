package org.gts.bst.ship.equip;
import spacetrader.Strings;
import spacetrader.enums.TechLevel;
import spacetrader.util.Hashtable;
import spacetrader.util.Log;


public class Weapon extends Equipment {
  private WeaponType _type;
  private boolean _disabling;
  private int _power;
  private static final String ss[] = {
    "_type", "_power", "_disabling"
  };

  public Weapon(Hashtable ht) {
    super(ht);
    _type = WeaponType.fromId(GetValueFromHash(ht, ss[0], Integer.class));
    _power = GetValueFromHash(ht, ss[1], Integer.class);
    _disabling = GetValueFromHash(ht, ss[2], false);
  }

  public Weapon(WeaponType w, int power, boolean disabling, int price, TechLevel t, int chance) {
    super(EquipmentType.Weapon, price, t, chance);
    _type = w;
    _power = power;
    _disabling = disabling;
  }

  @Override
  public Equipment Clone() {
    return new Weapon(_type, _power, _disabling, _price, _minTech, _chance);
  }

  @Override
  public EquipmentSubType SubType() {
    //TODO: Is this supposed to be irrelevant? GAC
    return _type;
  }

  @Override
  public Hashtable Serialize() {
    Hashtable ht = super.Serialize();
    ht.add(ss[0], _type.id);
    ht.add(ss[1], _power);
    ht.add(ss[2], _disabling);
    return ht;
  }

  @Override
  public String Name() {
    return Strings.WeaponNames[_type.id];
  }

  @Override
  public boolean TypeEquals(Object type) {
    boolean equal = false;
    try {
      if(_type == (WeaponType)type) {
        equal = true;
      }
    } catch(Exception e) {
      Log.write("Ignored exception " + e);
    }
    return equal;
  }

  public WeaponType Type() {
    return _type;
  }

  public boolean Disabling() {
    return _disabling;
  }

  public int Power() {
    return _power;
  }
}
