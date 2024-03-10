package org.spacetrader.model.ship.equipment;

import org.spacetrader.controller.Commander;
import org.spacetrader.controller.Game;
import org.spacetrader.controller.SerializableObject;
import org.spacetrader.ui.Strings;
import org.spacetrader.model.TechLevel;
import java.util.Hashtable;
import org.winforms.wfImage;


abstract public class Equipment extends SerializableObject implements Cloneable {
    protected EquipmentType _equipType;
    protected TechLevel _minTech;
    protected int _chance;
    protected int _price;

    public Equipment(EquipmentType type, int price, TechLevel minTechLevel, int chance) {
        _equipType = type;
        _price = price;
        _minTech = minTechLevel;
        _chance = chance;
    }

    public Equipment(Hashtable hash) {
        super(hash);
        _equipType = EquipmentType.FromInt(GetValueFromHash(hash, "_equipType", Integer.class));
        _price = GetValueFromHash(hash, "_price", Integer.class);
        _minTech = TechLevel.FromInt(GetValueFromHash(hash, "_minTech", Integer.class));
        _chance = GetValueFromHash(hash, "_chance", Integer.class);
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put("_equipType", _equipType.CastToInt());
        hash.put("_price", _price);
        hash.put("_minTech", _minTech.ordinal());
        hash.put("_chance", _chance);
        return hash;
    }

    @Override
    public String toString() {
        return Name();
    }

    protected int BaseImageIndex() {
        int baseImageIndex = 0;
        switch (EquipmentType()) {
            case Gadget:
                baseImageIndex = Strings.WeaponNames.length + Strings.ShieldNames.length;
                break;
            case Shield:
                baseImageIndex = Strings.WeaponNames.length;
                break;
            case Weapon:
                // baseImageIndex should be 0
                break;
        }
        return baseImageIndex;
    }

    public EquipmentSubType SubType() {
        return null;
    }

    public EquipmentType EquipmentType() {
        return _equipType;
    }

    public wfImage Image() {
        return Game.getCurrentGame().getParentWindow().EquipmentImages().getImages()[BaseImageIndex() + SubType().asInteger()];
    }

    public String Name() {
        return "Name not defined";
    }

    public TechLevel MinimumTechLevel() {
        return _minTech;
    }

    public int Chance() {
        return _chance;
    }

    public int Price() {
        Commander commander = Game.getCurrentGame().Commander();
        int price = 0;
        if (commander != null && commander.CurrentSystem().TechLevel().ordinal() >= MinimumTechLevel().ordinal()) {
            price = (_price * (100 - commander.getShip().Trader())) / 100;
        }
        return price;
    }

    public int SellPrice() {
        return _price * 3 / 4;
    }

    public int TransferPrice() {
        // The cost to transfer is 10% of the item worth. This is changed from actually PAYING the buyer about 8% to transfer items. - JAF
        return SellPrice() * 110 / 90;
    }

    abstract public Equipment Clone();

    abstract public boolean TypeEquals(Object type);
}
