package org.spacetrader.model.ship.equipment;

import org.spacetrader.model.crew.Commander;
import org.spacetrader.controller.Game;
import org.spacetrader.controller.SerializableObject;
import org.spacetrader.model.enums.TechLevel;
import org.spacetrader.ui.Strings;
import org.winforms.wfImage;

import java.util.Hashtable;


abstract public class Equipment extends SerializableObject implements Cloneable {

    protected EquipmentType equipType;
    protected TechLevel minTech;
    protected int chance;
    protected int price;

    public Equipment(EquipmentType type, int price, TechLevel minTechLevel, int chance) {
        equipType = type;
        this.price = price;
        minTech = minTechLevel;
        this.chance = chance;
    }

    public Equipment(Hashtable hash) {
        super(hash);
        equipType = EquipmentType.FromInt(GetValueFromHash(hash, "_equipType", Integer.class));
        price = GetValueFromHash(hash, "_price", Integer.class);
        minTech = TechLevel.FromInt(GetValueFromHash(hash, "_minTech", Integer.class));
        chance = GetValueFromHash(hash, "_chance", Integer.class);
    }

    @Override
    public Hashtable Serialize() {
        Hashtable hash = super.Serialize();
        hash.put("_equipType", equipType.getId());
        hash.put("_price", price);
        hash.put("_minTech", minTech.ordinal());
        hash.put("_chance", chance);
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
        return equipType;
    }

    public wfImage Image() {
        return Game.getCurrentGame().getParentWindow().EquipmentImages().getImages()[BaseImageIndex() + SubType().asInteger()];
    }

    public String Name() {
        return "Name not defined";
    }

    public TechLevel MinimumTechLevel() {
        return minTech;
    }

    public int Chance() {
        return chance;
    }

    public int Price() {
        Commander commander = Game.getCurrentGame().Commander();
        int price = 0;
        if (commander != null && commander.CurrentSystem().TechLevel().ordinal() >= MinimumTechLevel().ordinal()) {
            price = (this.price * (100 - commander.getShip().Trader())) / 100;
        }
        return price;
    }

    public int SellPrice() {
        return price * 3 / 4;
    }

    public int TransferPrice() {
        // The cost to transfer is 10% of the item worth. This is changed from actually PAYING the buyer about 8% to transfer items. - JAF
        return SellPrice() * 110 / 90;
    }

    abstract public Equipment Clone();

    abstract public boolean TypeEquals(Object type);
}
